package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MenuAccessDao;
import com.xsis.bootcamp.model.MenuAccess;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class MenuAccessDaoImpl extends SessionHibernate implements MenuAccessDao {
	Log log = LogFactory.getLog(super.getClass());

	@Override
	public MenuAccess getId(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MenuAccess where id=:id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		if (query.list().size()>0) {
			return (MenuAccess) query.list().get(0);
			
		} else {
			return null;
		}
	}

	@Override
	public void insert(MenuAccess menuAccess) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting").append(menuAccess).toString());
		getSession().merge(menuAccess);		
	}

	@Override
	public void update(MenuAccess menuAccess) throws Exception {
		this.log.debug(new StringBuilder().append("Updating").append(menuAccess).toString());
		getSession().merge(menuAccess);		
	}

	@Override
	public void delete(MenuAccess menuAccess) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting").append(menuAccess).toString());
		getSession().merge(menuAccess);				
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<MenuAccess> listAll() throws Exception {
		String query = new StringBuilder().append("from MenuAccess").toString();
		return getSession().createQuery(query).list();
	}
}
