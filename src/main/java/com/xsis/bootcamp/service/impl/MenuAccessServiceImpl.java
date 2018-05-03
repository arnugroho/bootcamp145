package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.MenuAccessDao;
import com.xsis.bootcamp.model.MenuAccess;
import com.xsis.bootcamp.service.MenuAccessService;

@Service
@Transactional
public class MenuAccessServiceImpl implements MenuAccessService {
	@Autowired
	private MenuAccessDao menuAccessDao;

	@Override
	public MenuAccess getId(int id) throws Exception {
		return menuAccessDao.getId(id);
	}

	@Override
	public void insert(MenuAccess menuAccess) throws Exception {
		menuAccessDao.insert(menuAccess);

	}

	@Override
	public void update(MenuAccess menuAccess) throws Exception {
		// TODO Auto-generated method stub
		menuAccessDao.update(menuAccess);
	}

	@Override
	public void delete(MenuAccess menuAccess) throws Exception {
		// TODO Auto-generated method stub
		menuAccessDao.delete(menuAccess);
	}

	@Override
	public Collection<MenuAccess> listAll() throws Exception {
		// TODO Auto-generated method stub
		return menuAccessDao.listAll();
	}

}
