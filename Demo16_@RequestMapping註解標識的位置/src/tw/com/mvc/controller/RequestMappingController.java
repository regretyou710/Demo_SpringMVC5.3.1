package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello") // 可用於表示不同模塊間的路徑
public class RequestMappingController {

	@RequestMapping("/testRequestMapping")
	public String success() {
		return "success";
	}
}
