package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MatkulDao;
import com.xsis.bootcamp.model.Matkul;

@Repository
public class MatkulDaoImpl extends HibernateDaoSupport implements MatkulDao {
	@Autowired
	public MatkulDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Matkul> listMatkul() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from matkul";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public Matkul getMatkul(int idMatkul) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from matkul where idMatkul = :idMatkul";
		Query query = session.createQuery(hql);
		query.setInteger("idMatkul", idMatkul);
		if (query.list().size() > 0) {
			return (Matkul) query.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void insertMatkul(Matkul matkul) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(matkul);
		
	}

	@Override
	public void updateMatkul(Matkul matkul) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(matkul);
	}

	@Override
	public void deleteMatkul(Matkul matkul) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(matkul);
	}

}
