package com.house.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.house.dao.BaseDao;
import com.house.service.BaseService;
import com.house.util.Pager;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource(name = "baseDao")  
	private  BaseDao<T> baseDao;
	
	@Override
	public boolean saveOrUpdate(T entity) {
		if (baseDao.saveOrUpdate(entity) != null) {
			return true;
		}
		return false;
	}

	@Override
	public T get(Serializable id) {
		return baseDao.get(id);
	}

	@Override
	public boolean delete(Serializable id) {
		try {
			baseDao.delete(get(id));
		} catch (Exception e) {
			logger.error("id[{}] del error msg:" + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public int countAll() {
		return baseDao.countAll().intValue();
	}

	@Override
	public int deleteAll(Collection<Serializable> ids) {

		return baseDao.deleteAll(ids);
	}

	@Override
	public T getByPropertyName(String propertyName, String value) {

		return baseDao.getByPropertyName(propertyName, value);
	}

	@Override
	public List<T> findAll() {

		return baseDao.findAll();
	}

	@Override
	public List<T> findByPropertyName(String propertyName, String value) {
		// TODO Auto-generated method stub
		return baseDao.findByPropertyName(propertyName, value);
	}

	@Override
	public List<T> findByPager(String propertyName, String value, Pager pager) {
		return baseDao.findByPager(propertyName, value, pager);
	}

	@Override
	public List<T> findByMapPager(Map<String, Object> map, Pager pager) {
		return baseDao.findByMapPager(map, pager);
	}

	public void setDao(BaseDao<T> baseDao) {  
        this.baseDao = baseDao;  
    }  

}
