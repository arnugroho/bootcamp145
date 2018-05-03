package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MenuDao;
import com.xsis.bootcamp.model.Menu;
import com.xsis.bootcamp.util.SessionHibernate;


@Repository
public class MenuDaoImpl extends SessionHibernate implements MenuDao{
	Log log = LogFactory.getLog(super.getClass());
	
	@Override
	public Menu getByCode(String mCode) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Menu where code = :mCode";
		Query query = session.createQuery(hql);
		query.setString("mCode", mCode);
		if (query.list().size() > 0) {
			return (Menu) query.list().get(0);
		} else {
			return null;
		}
	}
	
	

	public void update(Menu menu) throws Exception {
		this.log.debug(new StringBuilder().append("Updating ").append(menu).toString());
		getSession().merge(menu);
	}

	public void delete(Menu menu) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting ").append(menu).toString());
		getSession().delete(menu);
	}

	public void insert(Menu menu) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting ").append(menu).toString());
		getSession().save(menu);
	}

	@SuppressWarnings("unchecked")
	public Collection<Menu> listAll() throws Exception {
		String query = new StringBuilder().append("from Menu").toString();
		return getSession().createQuery(query).list();
	}

	

}
