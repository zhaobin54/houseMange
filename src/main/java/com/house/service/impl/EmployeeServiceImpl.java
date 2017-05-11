package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.dao.EmployeeDao;
import com.house.model.Employee;
import com.house.service.EmployeeService;
import com.house.util.Pager;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   
	@Autowired
	public EmployeeDao employeeDao;
	@Override
	public List<Employee> findByPage(Employee em,Pager pager){
		return employeeDao.findByPage(em, pager);
	}
	@Override
	public int countAll(){
		return employeeDao.countAll();
	}
}
