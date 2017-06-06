package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.RentHouseDao;
import com.house.model.RentHouse;
import com.house.service.RentHouseService;

@Service("roleService")
public class RentHouseServiceImpl extends BaseServiceImpl<RentHouse> implements RentHouseService{
    
	public RentHouseDao rentHouseDao;
	
	@Resource(name = "rentHouseDao")
	public void setDao(BaseDao<RentHouse> dao) {
		super.setDao(dao);
	}
}
