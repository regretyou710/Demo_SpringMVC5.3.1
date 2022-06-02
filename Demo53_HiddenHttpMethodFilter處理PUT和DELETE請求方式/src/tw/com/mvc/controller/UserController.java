package tw.com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	/**
	 * 使用RESTFul模擬用戶資源的增刪改查
	 * /user	GET	查詢所有用戶訊息	
	 * /user/1	GET	根據用戶id查詢用戶訊息	
	 * /user	POST	添加用戶訊息	
	 * /user	DELETE	刪除用戶訊息	
	 * /user	PUT	修改用戶訊息	
	 */
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getAllUser() {
		System.out.println("查詢所有用戶訊息");
		return "success";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getUserById(@PathVariable("id") String id) {
		System.out.println("根據用戶id查詢用戶訊息:" + id);
		return "success";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addUser(String username, String password) {
		System.out.println("添加用戶訊息:" + username + ", " + password);
		return "success";
	}
}
