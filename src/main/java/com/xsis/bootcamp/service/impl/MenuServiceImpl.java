package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.MenuDao;
import com.xsis.bootcamp.model.Menu;
import com.xsis.bootcamp.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;

	@Override
	public Menu getByCode(String mCode) throws Exception {
		// TODO Auto-generated method stub
		return menuDao.getByCode(mCode);
	}

	@Override
	public void insert(Menu menu) throws Exception {

		menuDao.insert(menu);

	}

	@Override
	public void update(Menu menu) throws Exception {
		menuDao.update(menu);

	}

	@Override
	public void delete(Menu menu) throws Exception {
		menuDao.delete(menu);

	}

	@Override
	public Collection<Menu> listAll() throws Exception {
		return menuDao.listAll();
	}


}
