package tw.com.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUpAndDownController {

	private ResponseEntity<byte[]> responseEntity;

	@RequestMapping("/testDown")
	public String testDown(HttpSession session) {
		try {
			responseEntity = testResponseEntity(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/msg/downErr";
		}
		return "forward:/downloadFile";
	}

	@RequestMapping("/downloadFile")
	public ResponseEntity<byte[]> downloadFile() {
		return responseEntity;
	};

	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
		// 獲取ServletContext對象
		ServletContext servletContext = session.getServletContext();

		// 獲取伺服器中檔的真實路徑
		String realPath = servletContext.getRealPath("/static/img/1.jpg");
		System.out.println(realPath);
		
		// 創建輸入流
		InputStream is = new FileInputStream(realPath);

		// 創建位元組陣列
		byte[] bytes = new byte[is.available()];

		// 將流讀到位元組陣列中
		is.read(bytes);

		// 創建HttpHeaders物件設置響應頭資訊
		MultiValueMap<String, String> headers = new HttpHeaders();

		// 設置要下載方式以及下載檔案的名字
		headers.add("Content-Disposition", "attachment;filename=1.jpg");

		// 設置回應狀態碼
		HttpStatus statusCode = HttpStatus.OK;

		// 創建ResponseEntity對象
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

		// 關閉輸入流
		is.close();

		return responseEntity;
	}

}
