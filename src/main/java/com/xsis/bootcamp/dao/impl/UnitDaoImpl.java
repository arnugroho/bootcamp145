package com.xsis.bootcamp.dao.impl;

import java.util.Collection;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.UnitDao;
import com.xsis.bootcamp.model.Unit;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class UnitDaoImpl extends SessionHibernate implements UnitDao {

	public void insert(Unit unit) throws Exception {
		getSession().save(unit);
	}

	public void delete(Unit unit) throws Exception {
		getSession().delete(unit);

	}

	public void update(Unit unit) throws Exception {
		getSession().merge(unit);
	}

	@SuppressWarnings("unchecked")
	public Collection<Unit> listAll() throws Exception {
		String query = new StringBuilder().append("from Unit where isDelete= " + GeneralVariable.ISDELETE_FALSE).toString();
		return getSession().createQuery(query).list();
	}

	@Override
	public Unit get(Long idUnit) throws Exception {
		Unit unit = getSession().get(Unit.class, idUnit);
		return unit;
	}

}
