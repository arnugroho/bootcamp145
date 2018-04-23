package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MahasiswaDao;
import com.xsis.bootcamp.model.Mahasiswa;

@Repository
public class MahasiswaDaoImpl extends HibernateDaoSupport implements MahasiswaDao {
	@Autowired
	public MahasiswaDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mahasiswa> listMahasiswa() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from mahasiswa";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public Mahasiswa getMahasiswa(int nim) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from mahasiswa where nim = :nim";
		Query query = session.createQuery(hql);
		query.setInteger("nim", nim);
		if (query.list().size() > 0) {
			return (Mahasiswa) query.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void insertMahasiswa(Mahasiswa mahasiswa) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(mahasiswa);

	}

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(mahasiswa);

	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(mahasiswa);

	}

}
