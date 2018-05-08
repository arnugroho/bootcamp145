package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Muser;

public interface MuserDao {
	
	public Muser getByUserame(String pUsername) throws Exception;

	public Muser get(Integer idUser) throws Exception;

	public abstract void insert(Muser muser) throws Exception;

	public abstract void update(Muser muser) throws Exception;

	public abstract void delete(Muser muser) throws Exception;

	public abstract Collection<Muser> listAll() throws Exception;

}
