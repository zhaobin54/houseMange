package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.WagesDao;
import com.house.model.Wages;

@Repository("wagesDao")
public class WagesDaoImpl extends BaseDaoImpl<Wages> implements WagesDao {

}
