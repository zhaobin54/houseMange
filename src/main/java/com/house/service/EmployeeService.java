package com.house.service;

import java.util.List;

import com.house.model.Employee;
import com.house.util.Pager;

public interface EmployeeService {

	List<Employee> findByPage(Employee em, Pager pager);

	int countAll();

}
