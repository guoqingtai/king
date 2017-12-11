package knight.z9_test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService service;
	
	@RequestMapping("/addUser.do")
	public String addUser(HttpServletRequest request){
		return "hello";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
