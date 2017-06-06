package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.HouseDao;
import com.house.model.House;

@Repository("purchaseDao")
public class HouseDaoImpl extends BaseDaoImpl<House> implements HouseDao{

}
