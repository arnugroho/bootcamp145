package com.xsis.bootcamp.dao.impl;


import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.PromotionDao;
import com.xsis.bootcamp.model.Promotion;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class PromotionDaoImpl extends SessionHibernate implements PromotionDao {
	Log log = LogFactory.getLog(super.getClass());
	
	@Override
	public Promotion getById(String pId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Promotion where code = :pId";
		Query query = session.createQuery(hql);
		query.setString("pId", pId);
		if (query.list().size() > 0) {
			return (Promotion) query.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void insert(Promotion promotion) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting ").append(promotion).toString());
		getSession().save(promotion);
	}

	@Override
	public void update(Promotion promotion) throws Exception {
		this.log.debug(new StringBuilder().append("Updating ").append(promotion).toString());
		getSession().merge(promotion);
	}

	@Override
	public void delete(Promotion promotion) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting ").append(promotion).toString());
		getSession().delete(promotion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Promotion> listAll() throws Exception {
		String query = new StringBuilder().append("from Promotion").toString();
		return getSession().createQuery(query).list();
	}

}

