package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.FakultasDao;
import com.xsis.bootcamp.model.Fakultas;
import com.xsis.bootcamp.service.FakultasService;

@Service
@Transactional
public class FakultasServiceImpl implements FakultasService {

	@Autowired
	private FakultasDao fakultasDao;

	@Override
	public Collection<Fakultas> listFakultas() throws Exception {
		return fakultasDao.listFakultas();
	}

	@Override
	public void insertFakultas(Fakultas fakultas) throws Exception {
		fakultasDao.insertFakultas(fakultas);
	}

	@Override
	public void updateFakultas(Fakultas fakultas) throws Exception {
		fakultasDao.updateFakultas(fakultas);
	}

	@Override
	public void deleteFakultas(Fakultas fakultas) throws Exception {
		fakultasDao.deleteFakultas(fakultas);
	}

	@Override
	public Fakultas getFakultas(int idFakultas) throws Exception {
		// TODO Auto-generated method stub
		return fakultasDao.getFakultas(idFakultas);
	}
}
