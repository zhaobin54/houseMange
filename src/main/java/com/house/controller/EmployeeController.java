package com.house.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.house.model.Employee;
import com.house.service.EmployeeService;
import com.house.util.Pager;
import com.house.util.StringHelp;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends MultiActionController {

	@Autowired
	@Qualifier("employeeService")
	public EmployeeService employeeService;

	@RequestMapping(value = "/load.htmls")
	public ModelAndView load() {
		return new ModelAndView("employee/employeeList");
	}

	@RequestMapping(value = "/list.htmls")
	@ResponseBody
	public Map<String, Object> list(Employee em, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Pager pager = new Pager();
		int total = employeeService.countAll();
		map.put("total", total);
		pager.setTotalCount(total);
		int page = StringHelp.strToInt(request.getParameter("page"));
		String pagecount = request.getParameter("rows");
		pager.setPage(page);
		pager.setPageLines(pagecount == null ? 10 : Integer.parseInt(pagecount));
		List<Employee> employeeList = employeeService.findByPage(em, pager);
		map.put("rows", employeeList==null?new ArrayList<>():employeeList);
		return map;
	}
	
	@RequestMapping(value = "/addEm.htmls")
	@ResponseBody
	public Map<String, Object> addEm(Employee em, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", employeeService.saveOrUpdate(em));
		return map;
	}
	
	@RequestMapping(value = "/delEm.htmls")
	@ResponseBody
	public Map<String, Object> delEm(String uuid, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", employeeService.delete(uuid));
		return map;
	}
	
	
	
	
}
