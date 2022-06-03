package tw.com.mvc.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
