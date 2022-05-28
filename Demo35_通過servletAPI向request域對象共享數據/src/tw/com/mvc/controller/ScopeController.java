package tw.com.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {

	// 使用servletAPI向request域對象共享數據
	@RequestMapping("/testRequestByServletAPI")
	public String testRequestByServletAPI(HttpServletRequest request) {
		request.setAttribute("testRequestScope", "Hello,servletAPI");
		return "success";//透過server內部轉發
	}
}
