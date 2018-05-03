package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.MenuAccess;

public interface MenuAccessDao {
	
	public MenuAccess getId(int id) throws Exception;

	public abstract void insert(MenuAccess menuAccess) throws Exception;

	public abstract void update(MenuAccess menuAccess) throws Exception;

	public abstract void delete(MenuAccess menuAccess) throws Exception;

	public abstract Collection<MenuAccess> listAll() throws Exception;

}
