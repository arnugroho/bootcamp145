package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.MuserDao;
import com.xsis.bootcamp.model.Muser;
import com.xsis.bootcamp.service.MuserService;

@Service
@Transactional
public class MuserServiceImpl implements MuserService {
	@Autowired
	private MuserDao muserDao;

	@Override
	public Muser get(Long idUser) throws Exception {
		return muserDao.get(idUser);
	}

	@Override
	public Muser getByUsername(String pUsername) throws Exception {
		return muserDao.getByUserame(pUsername);
	}

	@Override
	public void insert(Muser muser) throws Exception {
		muserDao.insert(muser);
	}

	@Override
	public void update(Muser muser) throws Exception {
		muserDao.update(muser);
	}

	@Override
	public void delete(Muser muser) throws Exception {
		muserDao.delete(muser);
	}

	@Override
	public Collection<Muser> listAll() throws Exception {
		return muserDao.listAll();
	}
}
