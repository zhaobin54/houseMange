package com.house.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.dao.DictionariesDao;
import com.house.model.Dictionaries;
import com.house.service.DictionariesService;

@Service("dictionariesService")
public class DictionariesServiceImpl extends BaseServiceImpl<Dictionaries> implements DictionariesService {

	public DictionariesDao dictionariesDao;

	@Resource(name = "dictionariesDao")
	public void setDao(BaseDao<Dictionaries> dao) {
		super.setDao(dao);
	}
}
