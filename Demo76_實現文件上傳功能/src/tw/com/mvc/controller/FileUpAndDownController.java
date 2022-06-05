package tw.com.mvc.controller;

import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping("/testUp")
	public String testUp(MultipartFile photo, HttpSession session) throws IllegalStateException, IOException {
		// springMVC中將上傳的文件封裝到MultipartFile對象裡
		// 行參名稱和請求參數名稱要相同

		// System.out.println(photo.getName());// 獲取參數名
		// System.out.println(photo.getOriginalFilename());// 獲取上傳檔案名稱

		// 獲取ServletContext對象
		ServletContext servletContext = session.getServletContext();

		// 獲取伺服器中檔的真實路徑
		String realPath = servletContext.getRealPath("/upload");

		File file = new File(realPath);

		// 判斷realPath所對應的路徑是否存在
		if (!file.exists())
			file.mkdir();

		String finalPath = realPath + File.separator + photo.getOriginalFilename();
		System.out.println(finalPath);

		photo.transferTo(new File(finalPath));
		return "success";
	}
}
