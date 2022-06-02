package tw.com.mvc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.mvc.rest.dao.EmployeeDAO;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
}
