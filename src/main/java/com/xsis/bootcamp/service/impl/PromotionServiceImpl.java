package com.xsis.bootcamp.service.impl;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.PromotionDao;
import com.xsis.bootcamp.model.Promotion;
import com.xsis.bootcamp.service.PromotionService;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionDao promotionDao;

	@Override
	public Promotion getById(String pId) throws Exception {
		return promotionDao.getById(pId);
	}

	@Override
	public void insert(Promotion promotion) throws Exception {
		promotionDao.insert(promotion);
	}

	@Override
	public void update(Promotion promotion) throws Exception {
		promotionDao.update(promotion);
		
	}

	@Override
	public void delete(Promotion promotion) throws Exception {
		promotionDao.delete(promotion);
	}

	@Override
	public Collection<Promotion> listAll() throws Exception {
		return promotionDao.listAll();
	}
	


}
