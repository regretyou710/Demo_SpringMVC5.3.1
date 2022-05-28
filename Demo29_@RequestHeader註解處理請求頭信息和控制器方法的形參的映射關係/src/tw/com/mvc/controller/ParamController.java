package tw.com.mvc.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String testParam2(/**
								 * value：指定為形參賦值的請求參數的參數名 required：設置是否必須傳輸此請求參數，預設值為true
								 * 若設置為true時，則當前請求必須傳輸value所指定的請求參數，若沒有傳輸該請求參數，且沒有設置defaultValue屬性，則頁面報錯400：Required
								 * String parameter 'xxx' is not
								 * present；若設置為false，則當前請求不是必須傳輸value所指定的請求參數，若沒有傳輸，則注解所標識的形參的值為null
								 * defaultValue：不管required屬性值為true或false，當value所指定的請求參數沒有傳輸或傳輸的值為""時，則使用預設值為形參賦值
								 */
	@RequestParam(value = "user_name", required = false, defaultValue = "system") String username, String password,
			String[] hobby) {
		// 若請求參數中出現多個同名的請求參數，可以再控制器方法的形參位置設置字串類型或字串陣列接收此請求參數
		// 若使用字串類型的形參，最終結果為請求參數的每一個值之間使用逗號進行拼接
		System.out.printf("username:%s, password:%s, hobby:%s%n", username, password, Arrays.toString(hobby));
		return "success";
	}

	@RequestMapping("/testParam3")
	public String testParam3(
			@RequestParam(value = "user_name", required = false, defaultValue = "system") String username,
			String password, String[] hobby, @RequestHeader("Host") String host) {
		System.out.printf("username:%s, password:%s, hobby:%s%n", username, password, Arrays.toString(hobby));
		System.out.printf("Host:%s%n", host);
		return "success";
	}

	@RequestMapping("/testParam3_1")
	public String testParam3_1(
			// @RequestHeader屬性使用與@RequestParam相同
			@RequestParam(value = "user_name", required = false, defaultValue = "system") String username,
			String password, String[] hobby,
			@RequestHeader(value = "Host1", required = true, defaultValue = "host1") String host) {
		System.out.printf("username:%s, password:%s, hobby:%s%n", username, password, Arrays.toString(hobby));
		System.out.printf("Host:%s%n", host);
		return "success";
	}
}
