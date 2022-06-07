package tw.com.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = { ArithmeticException.class, NullPointerException.class })
	public String catchException(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "msg/error";
	}
}
