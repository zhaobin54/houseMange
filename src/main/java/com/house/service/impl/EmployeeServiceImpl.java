package com.house.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.EmployeeDao;
import com.house.model.Employee;
import com.house.service.EmployeeService;
import com.house.util.Pager;

@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService{
   
	@Resource(name = "employeeDao")  
	public EmployeeDao employeeDao;
	
	@Resource(name = "employeeDao")  
	public void setDao(BaseDao<Employee> dao) {  
        super.setDao(dao);  
    }  
	@Override
	public List<Employee> findByPage(Employee em,Pager pager){
		return employeeDao.findByPage(em, pager);
	}
	
}
