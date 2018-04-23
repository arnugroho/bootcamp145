package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.PersonelDao;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.util.SessionHibernate;


@Repository
public class PersonelDaoImpl extends SessionHibernate implements PersonelDao{
	Log log = LogFactory.getLog(super.getClass());
	
	@Override
	public Personel getByUserName(String pUsername) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Personel where username = :pUsername";
		Query query = session.createQuery(hql);
		query.setString("pUsername", pUsername);
		if (query.list().size() > 0) {
			return (Personel) query.list().get(0);
		} else {
			return null;
		}
	}
	
	

	public void update(Personel personel) throws Exception {
		this.log.debug(new StringBuilder().append("Updating ").append(personel).toString());
		getSession().merge(personel);
	}

	public void delete(Personel personel) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting ").append(personel).toString());
		getSession().delete(personel);
	}

	public void insert(Personel personel) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting ").append(personel).toString());
		getSession().save(personel);
	}

	@SuppressWarnings("unchecked")
	public Collection<Personel> listAll() throws Exception {
		String query = new StringBuilder().append("from Personel").toString();
		return getSession().createQuery(query).list();
	}

	

}
