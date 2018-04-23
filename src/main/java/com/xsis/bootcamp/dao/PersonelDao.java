package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Personel;

public interface PersonelDao{

	public Personel getByUserName(String pUsername) throws Exception;
	
	public abstract void insert(Personel personel) throws Exception;

	public abstract void update(Personel personel) throws Exception;

	public abstract void delete(Personel personel) throws Exception;
	
	public abstract Collection<Personel> listAll() throws Exception;

}
