package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.MatkulDao;
import com.xsis.bootcamp.model.Matkul;
import com.xsis.bootcamp.service.MatkulService;


@Service
@Transactional
public class MatkulServiceImpl implements MatkulService {

	@Autowired
	private MatkulDao matkulDao;
	
	@Override
	public Collection<Matkul> listMatkul() throws Exception {
		return matkulDao.listMatkul();
		}

	@Override
	public Matkul getMatkul(int idMatkul) throws Exception {
		return matkulDao.getMatkul(idMatkul);
	}

	@Override
	public void insertMatkul(Matkul matkul) throws Exception {
		matkulDao.insertMatkul(matkul);

	}

	@Override
	public void updateMatkul(Matkul matkul) throws Exception {
		matkulDao.updateMatkul(matkul);

	}

	@Override
	public void deleteMatkul(Matkul matkul) throws Exception {
		matkulDao.deleteMatkul(matkul);

	}

}
