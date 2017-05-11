package com.house.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.house.dao.EmployeeDao;
import com.house.model.Employee;
import com.house.util.Pager;
import com.house.util.StringHelp;

@Repository
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao{

	@Autowired
	public SessionFactory sessionFactory;
	
	public List<Employee> findByPage(Employee em,Pager pager){
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        if(!StringHelp.isNullOrBlank(em.getName())){
        	c.add(Restrictions.eq("name", em.getName()));
        }
        if (pager.getOverleapLines() != null) {
            c.setFirstResult(pager.getOverleapLines());
        }
        if (pager.getPageLines() != null) {
            c.setMaxResults(pager.getPageLines());
        }
      
        if (c.list() != null && c.list().size() > 0) {
            return c.list();
        }
       
        return null;
	}
}
