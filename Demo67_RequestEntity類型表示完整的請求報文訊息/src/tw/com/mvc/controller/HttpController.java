package tw.com.mvc.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpController {

	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String requestBody) {
		System.out.println("requestBody:" + requestBody);
		return "success";
	}

	@RequestMapping("/testRequestEntity")
	public String testRequestEntity(RequestEntity<String>  requestEntity) {
		//當前requestEntity表示整個請求報文的訊息
		System.out.println("請求頭:" + requestEntity.getHeaders());
		System.out.println("請求體:" + requestEntity.getBody());
		return "success";
	}
}
