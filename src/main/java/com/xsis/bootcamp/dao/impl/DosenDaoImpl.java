package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.DosenDao;
import com.xsis.bootcamp.model.Dosen;

@Repository
public class DosenDaoImpl extends HibernateDaoSupport implements DosenDao{
	@Autowired
	public DosenDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Dosen> listDosen() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from dosen";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	@Override
	public Dosen getDosen(int nikDosen) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from dosen where nikDosen = :nikDosen";
		Query query = session.createQuery(hql);
		query.setInteger("nikDosen", nikDosen);
		if (query.list().size() > 0) {
			return (Dosen) query.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void insertDosen(Dosen dosen) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(dosen);
		
	}

	@Override
	public void updateDosen(Dosen dosen) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(dosen);
		
	}

	@Override
	public void deleteDosen(Dosen dosen) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(dosen);
	}

}
