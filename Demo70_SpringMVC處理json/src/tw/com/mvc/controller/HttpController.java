package tw.com.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.mvc.bean.User;

@Controller
public class HttpController {

	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String requestBody) {
		System.out.println("requestBody:" + requestBody);
		return "success";
	}

	@RequestMapping("/testRequestEntity")
	public String testRequestEntity(RequestEntity<String> requestEntity) {
		// 當前requestEntity表示整個請求報文的訊息
		System.out.println("請求頭:" + requestEntity.getHeaders());
		System.out.println("請求體:" + requestEntity.getBody());
		return "success";
	}

	@RequestMapping("/testResponse")
	public void testResponse(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello,response");
	}

	@RequestMapping("/testResponseBody")
	@ResponseBody
	public String testResponseBody() {
		// 加上@ResponseBody後，會返回響應體內容而不是試圖頁面
		return "ResponseBody";
	}

	@RequestMapping("/testResponseUser")
	@ResponseBody
	public User testResponseUser() {
		return new User(1001, "admin", "1234", 23, "男");
	}
}
