package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/testThymeleafView")
	public String testThymeleafView() {
		// 轉發一個頁面
		return "success";
	}

	@RequestMapping("/testForward")
	public String testForward() {
		// 轉發一個請求
		// 第一次請求，創建InternalResourceView
		// 第二次根據forward找到映射的請求/testThymeleafView，創建ThymeleafView
		return "forward:/testThymeleafView";
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		// 1. 重定向無法導向WEB-INFO底下的頁面
		// 2. 因為頁面都要被thymeleaf進行解析，必須透過轉發訪問thymeleaf，所以重定向會是一個請求而不是頁面
		return "redirect:/testThymeleafView";
	}
}
