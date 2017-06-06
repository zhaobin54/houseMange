package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.EquipmentDao;
import com.house.model.Equipment;
import com.house.service.EquipmentService;

@Service("equipmentService")
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment> implements EquipmentService{
	
	public EquipmentDao equipmentDao;
	
	@Resource(name = "equipmentDao")  
	public void setDao(BaseDao<Equipment> dao) { 
		super.setDao(dao);  
    }  
}
