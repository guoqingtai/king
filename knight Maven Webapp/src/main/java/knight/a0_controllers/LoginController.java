package knight.a0_controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import knight.b0_mnt.entity.TUser;
import knight.b0_mnt.service.LoginService;

@Controller()
@RequestMapping("/")
public class LoginController {

	@Autowired
	BookDaoTest tst;
	@Autowired
	LoginService svs;

	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			//tst.testQueryById();
			TUser user = svs.getUser("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "login";
	}

	@RequestMapping("/index.htm")
	public String index(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping("/sidemenu.htm")
	public String menu(HttpServletRequest request) {
		//String menuName = request.getParameter("uri");
		//System.out.println(request.getSession().getAttribute("user").getClass());
		//Collection<GrantedAuthority> auths = (Collection<GrantedAuthority>) ((User) (request.getSession().getAttribute("user"))).getAuthorities();
		//for (GrantedAuthority auth : auths) {
		//	System.out.println(((SimpleGrantedAuthority) auth).getAuthority());
		//}
		//System.out.println(((User) (request.getSession().getAttribute("user"))).getAuthorities());
		//System.out.println("MENU:" + menuName);
		
		return svs.getMenuHtml((UserDetails)request.getSession().getAttribute("user"));
		//return menuName;
	}

	//@RequestMapping("/ajaxlist")
	//@ResponseBody // (springmvc的Jackson注解，返回json字符串)
	//public List<TResource> getResourceList() {
	//	List<User> list = svs.getResourceByRoleId(roleId);
	//	return list;
	//}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
