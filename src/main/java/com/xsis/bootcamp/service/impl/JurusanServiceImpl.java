package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.JurusanDao;
import com.xsis.bootcamp.model.Jurusan;
import com.xsis.bootcamp.service.JurusanService;

@Service
@Transactional
public class JurusanServiceImpl implements JurusanService{

	@Autowired
	private JurusanDao jurusanDao;

	@Override
	public Collection<Jurusan> listJurusan() throws Exception {
		return jurusanDao.listJurusan();
	}

	@Override
	public void insertJurusan(Jurusan jurusan) throws Exception {
		jurusanDao.insertJurusan(jurusan);
	}

	@Override
	public void updateJurusan(Jurusan jurusan) throws Exception {
		jurusanDao.updateJurusan(jurusan);
	}

	@Override
	public void deleteJurusan(Jurusan jurusan) throws Exception {
		jurusanDao.deleteJurusan(jurusan);
	}

	@Override
	public Jurusan getJurusan(int idJurusan) throws Exception {
		// TODO Auto-generated method stub
		return jurusanDao.getJurusan(idJurusan);
	}

}
