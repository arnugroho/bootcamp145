package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Menu;

public interface MenuService{
	
	public Menu getById(Long mId) throws Exception;
	
	public abstract void insert(Menu menu) throws Exception;

	public abstract void update(Menu menu) throws Exception;

	public abstract void delete(Menu menu) throws Exception;
	
	public abstract Collection<Menu> listAll() throws Exception;
	
}
