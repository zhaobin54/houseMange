package com.house.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.house.util.Pager;

public interface BaseService<T> {
	boolean saveOrUpdate(T entity);

	int countAll();

	T get(Serializable id);

	boolean delete(Serializable id);

	int deleteAll(Collection<Serializable> ids);

	T getByPropertyName(String propertyName, String value);

	List<T> findAll();

	List<T> findByPropertyName(String propertyName, String value);

	List<T> findByPager(String propertyName, String value, Pager pager);

	List<T> findByMapPager(Map<String, Object> map, Pager pager);
}
