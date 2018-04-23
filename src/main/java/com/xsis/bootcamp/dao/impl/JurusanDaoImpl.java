package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xsis.bootcamp.dao.JurusanDao;
import com.xsis.bootcamp.model.Jurusan;

public class JurusanDaoImpl extends HibernateDaoSupport implements JurusanDao {
	@Autowired
	public JurusanDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Jurusan> listJurusan() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from jurusan";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public void insertJurusan(Jurusan jurusan) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(jurusan);
	}

	@Override
	public void updateJurusan(Jurusan jurusan) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(jurusan);
	}

	@Override
	public void deleteJurusan(Jurusan jurusan) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(jurusan);
	}
}
