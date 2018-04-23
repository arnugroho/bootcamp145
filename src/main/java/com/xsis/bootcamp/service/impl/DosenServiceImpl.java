package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.DosenDao;
import com.xsis.bootcamp.model.Dosen;
import com.xsis.bootcamp.service.DosenService;

@Service
@Transactional
public class DosenServiceImpl implements DosenService {
	
	@Autowired
	private DosenDao dosenDao;
	
	@Override
	public Collection<Dosen> listDosen() throws Exception {
		return dosenDao.listDosen();
	}

	@Override
	public Dosen getDosen(int nikDosen) throws Exception {
		return dosenDao.getDosen(nikDosen);
	}

	@Override
	public void insertDosen(Dosen dosen) throws Exception {
		dosenDao.insertDosen(dosen);
		
	}

	@Override
	public void updateDosen(Dosen dosen) throws Exception {
		dosenDao.updateDosen(dosen);
		
	}

	@Override
	public void deleteDosen(Dosen dosen) throws Exception {
		dosenDao.deleteDosen(dosen);
		
	}

}
