package com.house.dao.impl;

import org.springframework.stereotype.Repository;

import com.house.dao.DictionariesDao;
import com.house.model.Dictionaries;

@Repository("dictionariesDao")
public class DictionariesDaoImpl extends BaseDaoImpl<Dictionaries> implements DictionariesDao{

}
