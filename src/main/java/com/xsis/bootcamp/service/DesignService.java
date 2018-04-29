package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Design;

public interface DesignService {

	public Design getByCode(String dCode) throws Exception;

	public abstract void insert(Design design) throws Exception;

	public abstract void update(Design design) throws Exception;

	public abstract void delete(Design design) throws Exception;

	public abstract Collection<Design> listAll() throws Exception;
}
