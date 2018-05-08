package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.DesignDao;
import com.xsis.bootcamp.model.Design;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class DesignDaoImpl extends SessionHibernate implements DesignDao {
	Log log = LogFactory.getLog(super.getClass());
	
	@Override
	public Design get(Integer idDesign) throws Exception {
		Design design = getSession().get(Design.class, idDesign);
		return design;
	}

	@Override
	public void insert(Design design) throws Exception {
		this.log.debug(new StringBuilder().append("Inserting").append(design).toString());
		getSession().save(design);
	}

	@Override
	public void update(Design design) throws Exception {
		this.log.debug(new StringBuilder().append("Updating").append(design).toString());
		getSession().merge(design);
	}

	@Override
	public void delete(Design design) throws Exception {
		this.log.debug(new StringBuilder().append("Deleting").append(design).toString());
		getSession().delete(design);
	}

	@SuppressWarnings("unchecked")
	public Collection<Design> listAll() throws Exception {
		String query = new StringBuilder().append("from Design").toString();
		return getSession().createQuery(query).list();
	}

}


