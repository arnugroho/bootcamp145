package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xsis.bootcamp.dao.FakultasDao;
import com.xsis.bootcamp.model.Fakultas;

public class FakultasDaoImpl extends HibernateDaoSupport implements FakultasDao {
	@Autowired
	public FakultasDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Fakultas> listFakultas() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from fakultas";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public void insertFakultas(Fakultas fakultas) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(fakultas);
	}

	@Override
	public void updateFakultas(Fakultas fakultas) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(fakultas);
	}

	@Override
	public void deleteFakultas(Fakultas fakultas) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(fakultas);
	}

}
