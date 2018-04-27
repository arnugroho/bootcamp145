package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.BukuDao;
import com.xsis.bootcamp.model.Buku;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class BukuDaoImpl  extends SessionHibernate implements BukuDao {
	
	public void update(Buku buku) throws Exception {
		getSession().merge(buku);
	}

	public void delete(Buku buku) throws Exception {
		getSession().delete(buku);
	}

	public void insert(Buku buku) throws Exception {
		getSession().save(buku);
	}

	@SuppressWarnings("unchecked")
	public Collection<Buku> listAll() throws Exception {
		String query = new StringBuilder().append("from Buku").toString();
		return getSession().createQuery(query).list();
	}

}
