package com.xsis.bootcamp.dao.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.CompanyDao;
import com.xsis.bootcamp.model.Company;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.util.SessionHibernate;

@Repository
public class CompanyDaoImpl extends SessionHibernate implements CompanyDao {
	Log Log = LogFactory.getLog(super.getClass());
	
	@Override
	public void insert (Company company) throws Exception {
		getSession().save(company);
		
	}

	@Override
	public void update(Company company) throws Exception {
		getSession().merge(company);
		
	}

	@Override
	public void delete(Company company) throws Exception {
		getSession().delete(company);
		
	}
	
	@SuppressWarnings("unchecked")

	public Collection<Company> listAll() throws Exception {
		String query = new StringBuilder().append("from Company where isDelete = " + GeneralVariable.ISDELETE_FALSE).toString();
		return getSession().createQuery(query).list();
	}

	@Override
	public Company get(int idCompany) throws Exception {
		Company company= getSession().get(Company.class, idCompany);
		return company;
	}
		
}
