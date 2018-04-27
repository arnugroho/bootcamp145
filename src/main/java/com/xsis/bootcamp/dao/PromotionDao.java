package com.xsis.bootcamp.dao;


import java.util.Collection;

import com.xsis.bootcamp.model.Promotion;

public interface PromotionDao {

	public Promotion getById(String pId) throws Exception;
	public abstract void insert(Promotion promotion) throws Exception;
	public abstract void update(Promotion promotion) throws Exception;
	public abstract void delete(Promotion promotion) throws Exception;
	public abstract Collection<Promotion> listAll() throws Exception;
}