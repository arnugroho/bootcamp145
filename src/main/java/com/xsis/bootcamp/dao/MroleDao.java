package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Mrole;

public interface MroleDao {
	public Mrole getRole(int id) throws Exception;

	public abstract void insert(Mrole mrole) throws Exception;

	public abstract void update(Mrole mrole) throws Exception;

	public abstract void delete(Mrole mrole) throws Exception;

	public abstract Collection<Mrole> listAll() throws Exception;

}
