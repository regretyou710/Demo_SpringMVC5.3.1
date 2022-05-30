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
}
