package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Unit;

public interface UnitDao {

	public void insert(Unit unit) throws Exception;

	public void delete(Unit unit) throws Exception;

	public void update(Unit unit) throws Exception;

	public Collection<Unit> listAll() throws Exception;
	
	public Unit get(Long idUnit)throws Exception;

}
