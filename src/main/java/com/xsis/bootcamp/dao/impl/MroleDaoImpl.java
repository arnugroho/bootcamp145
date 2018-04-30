package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MroleDao;
import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class MroleDaoImpl extends SessionHibernate implements MroleDao {
	Log log = LogFactory.getLog(super.getClass());

	@Override
	public void insert(Mrole mrole) throws Exception {
		getSession().save(mrole);
		
	}

	@Override
	public void update(Mrole mrole) throws Exception {
		// TODO Auto-generated method stub
		getSession().merge(mrole);
		
	}

	@Override
	public void delete(Mrole mrole) throws Exception {
		// TODO Auto-generated method stub
		getSession().delete(mrole);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mrole> listAll() throws Exception {
		// TODO Auto-generated method stub
		String query = new StringBuilder().append("from Mrole").toString();
		return getSession().createQuery(query).list();
	}

	/*@Override
	public Mrole getRole(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Mrole where id=:id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		if (query.list().size() > 0) {
			return (Mrole) query.list().get(0);
		} else {
			return null;
		}
	}*/

/*	@Override
	public void insert(Mrole mrole) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting").append(mrole).toString());
	}

	@Override
	public void update(Mrole mrole) throws Exception {
		this.log.debug(new StringBuilder().append("Updating").append(mrole).toString());

	}

	@Override
	public void delete(Mrole mrole) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting").append(mrole).toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mrole> listAll() throws Exception {
		Session session = this.getSession();
		String hql = "from Mrole";
		Query query = session.createQuery(hql);
		return query.list();
	}*/

}
