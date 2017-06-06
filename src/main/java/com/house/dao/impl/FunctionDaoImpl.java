package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.FunctionDao;
import com.house.model.Function;

@Repository("functionDao")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao{

}
