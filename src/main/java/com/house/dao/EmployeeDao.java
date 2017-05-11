package com.house.dao;

import java.util.List;

import com.house.model.Employee;
import com.house.util.Pager;

public interface EmployeeDao extends BaseDao<Employee>{
	List<Employee> findByPage(Employee em,Pager pager);
}
