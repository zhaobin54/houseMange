package com.house.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.house.util.Pager;

public interface BaseDao<T> {

	T saveOrUpdate(T entity);

	Long countAll();

	T get(Serializable id);

	void delete(T entity);

	int deleteAll(Collection<Serializable> ids);

	T getByPropertyName(String propertyName, String value);

	List<T> findAll();

	List<T> findByPropertyName(String propertyName, String value);

	List<T> findByPager(String propertyName, String value, Pager pager);

}
