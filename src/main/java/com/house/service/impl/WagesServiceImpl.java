package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.WagesDao;
import com.house.model.Wages;
import com.house.service.WagesService;

@Service("wagesService")
public class WagesServiceImpl extends BaseServiceImpl<Wages> implements WagesService {

	public WagesDao wagesDao;
	
	@Resource(name = "wagesDao")
	public void setDao(BaseDao<Wages> dao) {
		super.setDao(dao);
	}
}
