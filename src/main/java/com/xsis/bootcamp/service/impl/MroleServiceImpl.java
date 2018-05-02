package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.MroleDao;
import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.service.MroleService;

@Service
@Transactional
public class MroleServiceImpl implements MroleService {
	@Autowired
	private MroleDao mroleDao;

	@Override
	public void insert(Mrole mrole) throws Exception {
		mroleDao.insert(mrole);
	}

	@Override
	public void delete(Mrole mrole) throws Exception {
		mroleDao.delete(mrole);
	}

	@Override
	public void update(Mrole mrole) throws Exception {
		mroleDao.update(mrole);
	}

	@Override
	public Collection<Mrole> listAll() throws Exception {
		return mroleDao.listAll();
	}

	@Override
	public Mrole get(Long idRole) throws Exception {
		return mroleDao.get(idRole);
	}
}
