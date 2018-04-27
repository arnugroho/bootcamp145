package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Promotion;

public interface PromotionService {

	public Promotion getById(String pId) throws Exception;
	public abstract void insert(Promotion promotion) throws Exception;
	public abstract void update(Promotion promotion) throws Exception;
	public abstract void delete(Promotion promotion) throws Exception;
	public abstract Collection<Promotion> listAll() throws Exception;
}

