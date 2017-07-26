package knight.a0_controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class LoginController {

	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		return "index";
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
