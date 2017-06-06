package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.HouseDao;
import com.house.model.House;
import com.house.service.HouseService;

@Service("purchaseService")
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {

	public HouseDao houseDao;

	@Resource(name = "houseDao")
	public void setDao(BaseDao<House> dao) {
		super.setDao(dao);
	}
}
