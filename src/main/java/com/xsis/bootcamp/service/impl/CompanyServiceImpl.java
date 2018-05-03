package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.CompanyDao;
import com.xsis.bootcamp.model.Company;
import com.xsis.bootcamp.service.CompanyService;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public void insert(Company company) throws Exception {
		companyDao.insert(company);
		
	}

	@Override
	public void update(Company company) throws Exception {
		companyDao.update(company);
	}

	@Override
	public void delete(Company company) throws Exception {
		companyDao.delete(company);
	}

	@Override
	public Collection<Company> listAll() throws Exception {
		return companyDao.listAll();
	}

	@Override
	public Company get(int idCompany) throws Exception {
		return companyDao.get(idCompany);
	}
	
	
	
}
