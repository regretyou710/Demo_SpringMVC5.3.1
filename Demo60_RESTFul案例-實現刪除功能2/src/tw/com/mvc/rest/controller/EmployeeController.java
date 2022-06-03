package tw.com.mvc.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.com.mvc.rest.bean.Employee;
import tw.com.mvc.rest.dao.EmployeeDAO;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		Collection<Employee> employeeList = employeeDAO.getAll();
		model.addAttribute("employeeList", employeeList);
		return "employee_list";
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeDAO.delete(id);

		// 因為操作成功後就跟原來發送刪除的請求無關，所以使用重定向
		return "redirect:/employee";
	}
}
