package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.EquipmentDao;
import com.house.model.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl extends BaseDaoImpl<Equipment> implements EquipmentDao{

}
