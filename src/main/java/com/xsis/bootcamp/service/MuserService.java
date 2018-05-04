package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Muser;

public interface MuserService {
	public Muser get(Long idUser) throws Exception;

	public Muser getByUsername(String pUsername) throws Exception;

	public abstract void insert(Muser muser) throws Exception;

	public abstract void update(Muser muser) throws Exception;

	public abstract void delete(Muser muser) throws Exception;

	public abstract Collection<Muser> listAll() throws Exception;

}
