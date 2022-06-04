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

}
