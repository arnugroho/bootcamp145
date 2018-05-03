package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Mrole;

public interface MroleService {

	public Mrole get(Long idRole) throws Exception;

	public abstract void insert(Mrole mrole) throws Exception;

	public abstract void delete(Mrole mrole) throws Exception;

	public abstract void update(Mrole mrole) throws Exception;

	public abstract Collection<Mrole> listAll() throws Exception;

}
