package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TsetController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
