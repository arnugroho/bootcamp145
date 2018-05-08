package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.DesignDao;
import com.xsis.bootcamp.model.Design;
import com.xsis.bootcamp.service.DesignService;

@Service
@Transactional
public class DesignServiceImpl implements DesignService {

	@Autowired
	private DesignDao designDao;
	
	@Override
	public Design get(Integer idDesign) throws Exception {
		// TODO Auto-generated method stub
		return designDao.get(idDesign);
	}

	@Override
	public void insert(Design design) throws Exception {
		// TODO Auto-generated method stub
		designDao.insert(design);
	}

	@Override
	public void update(Design design) throws Exception {
		// TODO Auto-generated method stub
		designDao.update(design);
	}

	@Override
	public void delete(Design design) throws Exception {
		// TODO Auto-generated method stub
		designDao.delete(design);
	}

	@Override
	public Collection<Design> listAll() throws Exception {
		// TODO Auto-generated method stub
		return designDao.listAll();
	}

}
