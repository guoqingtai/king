package knight.b0_mnt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import knight.b0_mnt.dao.TMntDao;
import knight.b0_mnt.entity.TResource;
import knight.b0_mnt.entity.TRole;
import knight.b0_mnt.entity.TUser;
import knight.b0_mnt.service.menu.MenuUtil;

@Service
public class LoginService {

	Logger LOG = Logger.getLogger(getClass());

	public static final List<TRole> EMPTY_ROLES = new ArrayList<TRole>();

	public static final Map<String, TRole> EMPTY_ROLE_MAP = new HashMap<String, TRole>();

	public static final List<TResource> EMPTY_RESOURCES = new ArrayList<TResource>();

	private static List<TRole> ALL_ROLES = null;

	private static Map<String, TRole> ROLE_MAP = new HashMap<String, TRole>();

	private static List<TResource> ALL_RESOURCES = null;
	@Autowired
	TMntDao dao;
	
	public String getMenuHtml(UserDetails ud) {
		//System.out
		return MenuUtil.getHtml(ud, this.getRoleMap());
	}

	public TUser getUser(String userName) {
		if (dao == null) {
			LOG.error("dao is not created!");
		}
		TUser user = dao.queryByName(userName);
		List<TRole> roles = dao.queryRoleById(user.getUserId());
		user.setRoles(roles);
		return user;
	}

	/**
	 * 获取数据库中所有的ROLE
	 * 
	 * @return
	 */
	public List<TRole> getAllRoles() {
		// 查询数据库中所有的Role
		if (ALL_ROLES == null || ALL_ROLES.isEmpty()) {
			ALL_ROLES = getRoles();
		}
		// 如果查询失败，返回空表。
		if (ALL_ROLES == null) {
			return EMPTY_ROLES;
		} else {
			// 初始化RoleMAP
			if (ROLE_MAP == null || ROLE_MAP.isEmpty()) {
				for (TRole role : ALL_ROLES) {
					ROLE_MAP.put(String.valueOf(role.getRoleId()), role);
				}
			}
			return ALL_ROLES;
		}
	}

	/**
	 * 获取RoleMap
	 * @return
	 */
	public Map<String, TRole> getRoleMap() {
		if (ROLE_MAP == null || ROLE_MAP.isEmpty()) {
			getAllRoles();
		}
		if (ROLE_MAP == null || ROLE_MAP.isEmpty()) {
			return EMPTY_ROLE_MAP;
		}
		return ROLE_MAP;
	}
	
	/**
	 * 获取数据库中所有的Resource
	 * @return
	 */
	public List<TResource> getAllResources() {
		if (ALL_RESOURCES == null || ALL_RESOURCES.isEmpty()) {
			ALL_RESOURCES = dao.queryResource();
		}
		if (ALL_RESOURCES == null) {
			return EMPTY_RESOURCES;
		} else {
			return ALL_RESOURCES;
		}
	}

	public List<TResource> getResourceByRoleId(int roleId) {
		return dao.queryResourceByRoleId(roleId);
	}

	/**
	 * 刷新roles和resource。
	 */
	public static void refreshRolesAndResources() {
		ALL_ROLES = null;
		ALL_RESOURCES = null;
	}

	public List<TRole> getRoles() {
		if (dao == null) {
			LOG.error("dao is not created!");
		}
		List<TRole> roles = dao.queryRole();
		for (TRole role : roles) {
			List<TResource> resList = dao.queryResourceByRoleId(role.getRoleId());
			role.setResources(resList);
		}
		return roles;
	}

}
