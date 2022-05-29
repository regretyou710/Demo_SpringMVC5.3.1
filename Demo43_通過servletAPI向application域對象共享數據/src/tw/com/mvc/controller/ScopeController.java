package tw.com.mvc.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	@RequestMapping("/testModel")
	public String testModel(Model model) {
		model.addAttribute("testRequestScope", "Hello,Model");

		return "success";
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("testRequestScope", "Hello,Map");

		return "success";
	}

	@RequestMapping("/testModelMap")
	public String testModelMap(ModelMap modelMap) {
		modelMap.addAttribute("testRequestScope", "Hello,ModelMap");

		return "success";
	}

	@RequestMapping("testSession")
	public String testSession(HttpSession session) {
		session.setAttribute("testSessionScope", "Hello,Session");

		return "success";
	}

	@RequestMapping("testApplication")
	public String testApplication(HttpSession session) {
		ServletContext application = session.getServletContext();
		application.setAttribute("testApplicationScope", "Hello,Application");

		return "success";
	}
}
