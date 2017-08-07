package knight.a0_controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class LoginController {

	@Autowired BookDaoTest tst;
	
	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request) {
		return "login";
		
	}
	
	@RequestMapping("/index.htm")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	
	@RequestMapping("/test.htm")
	public String test(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		//BookDaoTest bkd = new BookDaoTest();
		try {
			tst.testQueryById() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
