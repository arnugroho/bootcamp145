package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Design;

public interface DesignDao {

	public Design get(Integer idDesign) throws Exception;

	public abstract void insert(Design design) throws Exception;

	public abstract void update(Design design) throws Exception;

	public abstract void delete(Design design) throws Exception;

	public abstract Collection<Design> listAll() throws Exception;

}
