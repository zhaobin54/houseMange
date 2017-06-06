package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.PurchaseDao;
import com.house.model.Purchase;

@Repository("purchaseDao")
public class PurchaseDaoImpl extends BaseDaoImpl<Purchase> implements PurchaseDao {

}
