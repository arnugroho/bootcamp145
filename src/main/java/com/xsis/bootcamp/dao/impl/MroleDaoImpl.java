package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.MroleDao;
import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class MroleDaoImpl extends SessionHibernate implements MroleDao {

	public void insert(Mrole mrole) throws Exception {
		getSession().save(mrole);
	}

	public void update(Mrole mrole) throws Exception {
		getSession().merge(mrole);
	}

	public void delete(Mrole mrole) throws Exception {
		getSession().delete(mrole);
	}

	@SuppressWarnings("unchecked")
	public Collection<Mrole> listAll() throws Exception {
		String query = new StringBuilder().append("from Mrole where isDelete = " + GeneralVariable.ISDELETE_FALSE)
				.toString();
		return getSession().createQuery(query).list();
	}

	@Override
	public Mrole get(Long idRole) throws Exception {
		Mrole mrole = getSession().get(Mrole.class, idRole);
		return mrole;
	}
}