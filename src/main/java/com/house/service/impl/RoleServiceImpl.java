package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.RoleDao;
import com.house.model.Role;
import com.house.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	public RoleDao roleDao;
	
	@Resource(name = "roleDao")
	public void setDao(BaseDao<Role> dao) {
		super.setDao(dao);
	}
}
