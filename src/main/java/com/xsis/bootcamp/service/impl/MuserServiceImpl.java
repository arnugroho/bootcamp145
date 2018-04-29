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
	public Muser getUser(int id) throws Exception {
		return muserDao.getUser(id);
	}

	@Override
	public void insert(Muser muser) throws Exception {
		muserDao.insert(muser);

	}

	@Override
	public void update(Muser muser) throws Exception {
		// TODO Auto-generated method stub
		muserDao.update(muser);
	}

	@Override
	public void delete(Muser muser) throws Exception {
		// TODO Auto-generated method stub
		muserDao.delete(muser);
	}

	@Override
	public Collection<Muser> listAll() throws Exception {
		// TODO Auto-generated method stub
		return muserDao.listAll();
	}

}
