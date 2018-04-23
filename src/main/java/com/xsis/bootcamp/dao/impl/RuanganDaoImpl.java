package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.RuanganDao;
import com.xsis.bootcamp.model.Ruangan;

@Repository
public class RuanganDaoImpl extends HibernateDaoSupport implements RuanganDao {
 @Autowired public RuanganDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
  
 
 
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Ruangan> listRuangan() throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Ruangan";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public void insertRuangan(Ruangan ruangan) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(ruangan);
	}

	@Override
	public void updateRuangan(Ruangan ruangan) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(ruangan);
	}

	@Override
	public void deleteRuangan(Ruangan ruangan) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(ruangan);
	}

	@Override
	public Ruangan getRuangan(int idruangan) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		String hql ="from Ruangan where idruangan= :idruangan";
		Query query= session.createQuery(hql);
		query.setInteger("idruangan", idruangan);
		return null;
	}

}
