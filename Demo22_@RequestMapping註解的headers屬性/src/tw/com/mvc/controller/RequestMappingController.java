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

	@RequestMapping(value = "/testPut", method = RequestMethod.PUT)
	public String testPut() {
		return "success";
	}

	// 表示請求映射必須滿足路徑為/testParamsAndHeaders且參數不能有username、password為123456
	// 且headers為localhost:8080，沒指定method時任何方法都可以匹配
	@RequestMapping(value = "/testParamsAndHeaders", params = { "!username", "password=123456" }, headers = {
			"host=localhost:8080" })
	public String tsetParamsAndHeaders() {
		return "success";
	}
}
