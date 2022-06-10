package tw.com.mvc.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorMsg {

	@RequestMapping("/testException")
	public String testException() {
		System.out.println(1 / 0);
		return "success";
	}
}
