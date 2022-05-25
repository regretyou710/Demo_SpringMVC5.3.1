package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingController {

	@RequestMapping(value = { "/testRequestMapping", "/test" })
	public String success() {
		return "success";
	}
}
