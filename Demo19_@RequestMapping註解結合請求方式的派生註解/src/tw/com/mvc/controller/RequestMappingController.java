package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {

	// method屬性:默認任何方法(GET、POST、PUT、DELETE...)都可以匹配
	// 使用method屬性時必須要有value，先匹配value再匹配method
	@RequestMapping(value = { "/testRequestMapping", "/test" }, method = { RequestMethod.GET })
	public String success() {
		return "success";
	}

	@GetMapping("/testGetMapping") // 使用GetMapping就可以不用再設置method屬性為GET
	public String testGetMapping() {
		return "success";
	}
}
