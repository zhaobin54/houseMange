package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.FunctionDao;
import com.house.model.Function;
import com.house.service.FunctionService;

@Service("functionService")
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements FunctionService {

	public FunctionDao functionDao;

	@Resource(name = "functionDao")
	public void setDao(BaseDao<Function> dao) {
		super.setDao(dao);
	}
}
