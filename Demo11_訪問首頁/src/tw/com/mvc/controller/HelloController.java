package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// 訪問路徑由根目錄"/"開始->WEB-INFO/templates/index.html
	// 前綴:/WEB-INFO/templates/
	// 後綴:.html
	@RequestMapping("/") // 將當前的請求與控制器方法來創建映射關係
	public String index() {
		// 返回視圖名稱
		return "index";
	}
}
