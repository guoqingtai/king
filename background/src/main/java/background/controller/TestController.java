package background.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class TestController {

	@RequestMapping("/test1.htm")
	public String test1(HttpServletRequest request) {
		System.out.println("Enter HOME!");
		return "home";
	}

	@RequestMapping("/test2.htm")
	public String test2(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Enter HOME TEST2!!");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("12345");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}

}
