package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.PurchaseDao;
import com.house.model.Purchase;
import com.house.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl extends BaseServiceImpl<Purchase> implements PurchaseService {

	public PurchaseDao purchaseDao;
	
	@Resource(name = "purchaseDao")
	public void setDao(BaseDao<Purchase> dao) {
		super.setDao(dao);
	}
}
