package tw.com.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeController {

	// 使用servletAPI向request域對象共享數據
	@RequestMapping("/testRequestByServletAPI")
	public String testRequestByServletAPI(HttpServletRequest request) {
		request.setAttribute("testRequestScope", "Hello,servletAPI");
		return "success";// 透過server內部轉發
	}

	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mav = new ModelAndView();

		// 處理模型數據，即向請求域request共享數據
		mav.addObject("testRequestScope", "Hello,ModelAndView");

		// 設置視圖名稱
		mav.setViewName("success");

		return mav;
	}
}
