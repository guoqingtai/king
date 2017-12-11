package knight.a0_controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import knight.b0_mnt.entity.TUser;
import knight.b0_mnt.service.LoginService;

@Controller()
@RequestMapping("/")
public class LoginController {

	public static Logger LOG = Logger.getLogger(LoginController.class);
	
	
	
	@Autowired
	BookDaoTest tst;
	
	@Autowired
	LoginService svs;

	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request) {
		LOG.debug("enter LoginController login");
		try {
			HttpSession session = request.getSession();
			//tst.testQueryById();
			TUser user = svs.getUser("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping("/index.htm")
	public String index(HttpServletRequest request) {
		LOG.debug("enter LoginController index");
		return "index";
	}

	@RequestMapping("/sidemenu.htm")
	public String menu(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println((UserDetails)request.getSession().getAttribute("user"));
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sidemenu";
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
