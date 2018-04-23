package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.FakultasDao;
import com.xsis.bootcamp.model.Fakultas;

@Repository
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
	public Fakultas getFakultas(int idFakultas) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from fakultas where idFakultas =: idFakultas";
		Query query = session.createQuery(hql);
		query.setInteger("idFakultas", idFakultas);
		if (query.list().size() > 0) {
			return (Fakultas) query.list().get(0);
		} else {
			return null;
		}
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
