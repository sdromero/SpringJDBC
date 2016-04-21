package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import data.Employee;
import data.EmployeeDao;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao empDao;
	
	@RequestMapping("GetEmployee.do")
	public  ModelAndView getEmployee(int id) {
		Employee emp = empDao.getEmployeeById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("employee", emp);
		return mv;
	}

}
