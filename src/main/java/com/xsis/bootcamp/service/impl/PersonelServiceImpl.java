package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.PersonelDao;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.PersonelService;

@Service
@Transactional
public class PersonelServiceImpl implements PersonelService{
	@Autowired
	private PersonelDao personelDao;

	@Override
	public Personel getByUserName(String pUsername) throws Exception {
		// TODO Auto-generated method stub
		return personelDao.getByUserName(pUsername);
	}

	@Override
	public void insert(Personel personel) throws Exception {

		personelDao.insert(personel);

	}

	@Override
	public void update(Personel personel) throws Exception {
		personelDao.update(personel);

	}

	@Override
	public void delete(Personel personel) throws Exception {
		personelDao.delete(personel);

	}

	@Override
	public Collection<Personel> listAll() throws Exception {
		return personelDao.listAll();
	}


}
