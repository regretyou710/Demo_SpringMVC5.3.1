package tw.com.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParamController {

	@RequestMapping("/testServletAPI")
	// 形參位置request表示當前請求
	public String testServletAPI(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.printf("username:%s, password:%s%n", username, password);
		return "success";
	}
}
