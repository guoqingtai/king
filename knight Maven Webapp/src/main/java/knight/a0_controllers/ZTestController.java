package knight.a0_controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/test")
public class ZTestController {

	@RequestMapping("/test.htm")
	public String test(HttpServletRequest request) {
		System.out.println("1111");
		return "test/test";
	}
	
	@RequestMapping("/ajaxtest.htm") 
	public void ajaxtest(HttpServletRequest request, HttpServletResponse rsp) {
		System.out.println("ajaxtest1111111111111111111111111111111111");
		try {
			rsp.getWriter().println("1223455");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
