package tw.com.mvc.controller;

import java.util.Arrays;

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

	@RequestMapping("/testParam")
	public String testParam(String username, String password) {
		System.out.printf("username:%s, password:%s%n", username, password);
		return "success";
	}

	@RequestMapping("/testParam2")
	public String testParam2(String username, String password, String[] hobby) {
		// 若請求參數中出現多個同名的請求參數，可以再控制器方法的形參位置設置字串類型或字串陣列接收此請求參數
		// 若使用字串類型的形參，最終結果為請求參數的每一個值之間使用逗號進行拼接
		System.out.printf("username:%s, password:%s, hobby:%s%n", username, password, Arrays.toString(hobby));
		return "success";
	}
}
