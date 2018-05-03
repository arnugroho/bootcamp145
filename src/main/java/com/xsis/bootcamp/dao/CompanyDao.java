package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Company;

public interface CompanyDao {

	public Company get(int idCompany) throws Exception;
	
	public abstract void insert(Company company) throws Exception;

	public abstract void update(Company company) throws Exception;

	public abstract void delete(Company company) throws Exception;

	public abstract Collection<Company> listAll() throws Exception;
	
}
