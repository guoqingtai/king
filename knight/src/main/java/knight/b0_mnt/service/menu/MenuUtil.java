package knight.b0_mnt.service.menu;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import knight.b0_mnt.entity.TMenu;
import knight.b0_mnt.entity.TResource;
import knight.b0_mnt.entity.TRole;

public class MenuUtil {

	private static final String UL[] = { "<ul>", "</ul>" };
	private static final String LI[] = { "<li>", "</li>" };

	/*
	 * 
    	<ul>
        	<li><a href="#formsub" class="editor">表单提交</a>
            	<span class="arrow"></span>
            	<ul id="formsub">
               		<li><a href="forms.html">基础表单</a></li>
                </ul>
            </li>
            <!--<li><a href="filemanager.html" class="gallery">文件管理</a></li>-->
            <li><a href="elements.html" class="elements">网页元素</a></li>
        </ul>
	 */
	/**
	 * 拼串，获得菜单栏
	 * @param user
	 * @param map
	 * @return
	 */
	public static String getHtml(UserDetails user, Map<String, TRole> map) {

		// 首先需要获取用户下的Resource
		TMenu root = buildMenuTree(user, map);
		StringBuilder sb = new StringBuilder();
		sb.append(UL[0]);
		List<TMenu> topLevelMenu = root.getSubMenu();
		for (TMenu menu : topLevelMenu) {
			if (menu == null) {
				continue;
			}
			if (menu.getSubMenu() == null || menu.getSubMenu().isEmpty()) {
				TResource res = menu.getRes();
				//没有子菜单
				sb.append(LI[0]);
				sb.append("<a href=\"").append(res.getUri()).append("\" class=\"").append(res.getImg()).append("\">");
				sb.append(res.getZh()).append("</a>");
				sb.append(LI[1]);
			}
			//有子菜单
			else {
				TResource res = menu.getRes();
				sb.append(LI[0]);
				sb.append("<li><a href=\"#").append(res.getUri()).append("\" class=\"").append(res.getImg()).append("\">");
				sb.append("</a>");
				sb.append("<span class=\"arrow\"></span>");
				sb.append("<ul id=\"").append(res.getUri()).append("\">");
				for (TMenu tempMenu : menu.getSubMenu()) {
					TResource tempRes = tempMenu.getRes();
					sb.append("<li><a href=\"#").append(tempRes.getUri()).append("\" class=\"").append(tempRes.getImg()).append("\">");
				}
				sb.append("</ul>");
				sb.append(LI[1]);
			}
		}
		sb.append(UL[1]);
		return sb.toString();
	}

	/**
	 * 获取
	 * @param user
	 * @param allRoles
	 * @return
	 */
	private static TMenu buildMenuTree(UserDetails user, Map<String, TRole> allRoles) {
		Set<TResource> resList = new HashSet<TResource>();
		Set<Entry<String, TRole>> roleEntry = allRoles.entrySet();
		for (Entry<String, TRole> role : roleEntry) {
			resList.addAll(role.getValue().getResources());
		}
		// 获得了所有的Resource。现在需要组建Menu
		List<TMenu> menus = new LinkedList<TMenu>();
		for (TResource res : resList) {
			TMenu menu = new TMenu();
			menu.setRes(res);
			menus.add(menu);
		}
		//组织Menu树
		TMenu root = new TMenu();
		List<TMenu> topLevelMenus = new LinkedList<TMenu>();
		root.setSubMenu(topLevelMenus);
		for (TMenu menu : menus) {
			List<TMenu> subMenu = new LinkedList<TMenu>();
			if (menu.getRes().getParent() == 0)
			{
				topLevelMenus.add(menu);
			}
			for (TMenu temp : menus) {
				if (temp.getRes().getParent() == menu.getRes().getResId()) {
					subMenu.add(temp);
				}
			}
			menu.setSubMenu(subMenu);
		}
		return root;
	}

	/**
	 * 获得用户的RoleID
	 * 
	 * @param user
	 * @return
	 */
	private static List<String> getUserRoleId(UserDetails user) {
		Collection<SimpleGrantedAuthority> auths = (Collection<SimpleGrantedAuthority>) user.getAuthorities();
		List<String> roleIds = new LinkedList<String>();
		for (SimpleGrantedAuthority auth : auths) {
			roleIds.add(auth.getAuthority());
		}
		return roleIds;
	}
	
	public static void main (String args[]) {
		//将menu根据num排序
		//这个再说吧。
	}
}
