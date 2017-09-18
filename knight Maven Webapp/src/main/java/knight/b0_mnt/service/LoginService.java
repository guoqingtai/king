package knight.b0_mnt.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import knight.b0_mnt.dao.TMntDao;
import knight.b0_mnt.entity.TResource;
import knight.b0_mnt.entity.TRole;
import knight.b0_mnt.entity.TUser;

@Service
public class LoginService {
	
	Logger LOG = Logger.getLogger(getClass());
	
	@Autowired TMntDao dao;
	
	
	public TUser getUser(String userName) {
		if (dao == null) {
			LOG.error("dao is not created!");
		}
		TUser user = dao.queryByName(userName);
		List<TRole> roles = dao.queryRoleById(user.getUserId());
		user.setRoles(roles);
		return user;
	}
	
	public List<TRole> getRoles() {
		return dao.queryRole();
	}
	
	public List<TResource> getResourceByRoleId(int roleId) {
		return dao.queryResourceByRoleId(roleId);
	}
	

}
