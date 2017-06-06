package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.RoleDao;
import com.house.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
