package com.house.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.house.dao.BaseDao;
import com.house.dao.EmployeeDao;
import com.house.model.Employee;
import com.house.util.Pager;
import com.house.util.ReflectionHelper;
import com.house.util.StringHelp;

@Repository
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected Class<T> persistentClass;
	protected SessionFactory sessionFactory;

	public BaseDaoImpl() {
		this.persistentClass = ReflectionHelper.getSuperClassGenricType(getClass());
	}

	public BaseDaoImpl(SessionFactory sessionFactory, Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Session getSession() {
		if (isMapModel()) {
			return this.sessionFactory.getCurrentSession();
		}
		return this.sessionFactory.getCurrentSession();
	}

	private boolean isMapModel() {
		return (this.persistentClass != null) && (this.persistentClass.getName().equals("java.util.Map"));
	}

	@Override
	public T saveOrUpdate(T entity) {
		return (T) getSession().merge(entity);
	}

	@Override
	public T get(Serializable id) {
		return (T) getSession().load(persistentClass, id);
	}
	@Override
	public void delete(T entity) {
		try {
			getSession().delete(entity);
		} catch (Exception e) {
			logger.debug("delete entity {}", this.persistentClass.getSimpleName());
		}
		logger.debug("delete entity {}", this.persistentClass.getSimpleName());
	}
	@Override
	public int deleteAll(Collection<Serializable> ids) {
		String sql = "delete from " + this.persistentClass;
		String idStr = "";
		for (Serializable id : ids) {
			if (id instanceof String) {
				idStr += "'" + id + "',";
			} else {
				idStr += id + ",";
			}
		}
		if (StringHelp.isNullOrBlank(idStr)) {
			return 0;
		}
		sql = sql + "where " + getIdName() + " in (" + idStr.substring(0, idStr.length() - 1) + ")";
		return (int) createQuery(sql);
	}

	@Override
	public Long countAll() {
		String hql = "select count(*) from " + persistentClass.getSimpleName();
		Query query = getSession().createQuery(hql);
		return (long) query.uniqueResult();
	}

	@Override
	public T getByPropertyName(String propertyName, String value) {
		Criteria c = getSession().createCriteria(persistentClass);
		Assert.hasText(propertyName, "propertyName不能为空");
		if (!StringHelp.isNullOrBlank(value)) {
			c.add(Restrictions.eq(propertyName, value));
			if (c.list().size() > 0) {
				return (T) c.list().get(0);
			}
		}
		logger.warn("{}为空 {}不为空");
		return null;
	}

	@Override
	public List<T> findAll() {
		String hql = "select *from " + this.persistentClass;
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<T> findByPropertyName(String propertyName, String value) {
		Criteria c = getSession().createCriteria(persistentClass);
		Assert.hasText(propertyName, "propertyName不能为空");
		if (!StringHelp.isNullOrBlank(value)) {
			c.add(Restrictions.eq(propertyName, value));
			if (c.list().size() > 0) {
				return c.list();
			}
		}
		return null;
	}

	@Override
	public List<T> findByPager(String propertyName, String value, Pager pager) {
		Criteria c = getSession().createCriteria(persistentClass);
		Assert.hasText(propertyName, "propertyName不能为空");
		if (!StringHelp.isNullOrBlank(value)) {
			c.add(Restrictions.eq(propertyName, value));
		}
		if (pager.getOverleapLines() != null) {
			c.setFirstResult(pager.getOverleapLines());
		}
		if (pager.getPageLines() != null) {
			c.setMaxResults(pager.getPageLines());
		}
		if (c.list().size() > 0) {
			return c.list();
		}
		return null;
	}

	public Object createQuery(String sql) {
		Query query = getSession().createQuery(sql);
		return query.uniqueResult();
	}

	public Query createQuery(String queryString, Object[] values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(this.persistentClass);
		return meta.getIdentifierPropertyName();
	}

	public static void main(String[] args) {
		
	}
}
