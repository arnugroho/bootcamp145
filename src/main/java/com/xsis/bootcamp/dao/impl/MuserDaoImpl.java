package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MuserDao;
import com.xsis.bootcamp.model.Muser;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class MuserDaoImpl extends SessionHibernate implements MuserDao {
	Log log = LogFactory.getLog(super.getClass());

	@Override
	public Muser getByUserame(String pUsername) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Muser where username = :pUsername";
		Query query = session.createQuery(hql);
		query.setString("pUsername", pUsername);
		if (query.list().size()>0) {
			return (Muser) query.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public Muser get(Integer idUser) throws Exception {
		Muser muser = getSession().get(Muser.class, idUser);
		return muser;
	}

	@Override
	public void insert(Muser muser) throws Exception {
		getSession().save(muser);
	}

	@Override
	public void update(Muser muser) throws Exception {
		getSession().update(muser);
	}

	@Override
	public void delete(Muser muser) throws Exception {
		getSession().delete(muser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Muser> listAll() throws Exception {
		String query = new StringBuilder().append("from Muser where isDelete = "  + GeneralVariable.ISDELETE_FALSE).toString();
		return getSession().createQuery(query).list();
	}

	/*@Override
	public Muser getUser(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Muser where id=:id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		if (query.list().size()>0) {
			return (Muser) query.list().get(0);
			
		} else {
			return null;
		}
	}

	@Override
	public void insert(Muser muser) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting").append(muser).toString());
		getSession().merge(muser);		
	}

	@Override
	public void update(Muser muser) throws Exception {
		this.log.debug(new StringBuilder().append("Updating").append(muser).toString());
		getSession().merge(muser);		
	}

	@Override
	public void delete(Muser muser) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting").append(muser).toString());
		getSession().merge(muser);				
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Muser> listAll() throws Exception {
		String query = new StringBuilder().append("from Muser").toString();
		return getSession().createQuery(query).list();
	}

	@Override
	public Muser getByUserame(String pUsername) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/
}
