package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.MahasiswaDao;
import com.xsis.bootcamp.model.Mahasiswa;
import com.xsis.bootcamp.service.MahasiswaService;

@Service
@Transactional
public class MahasiswaServiceImpl implements MahasiswaService {

	@Autowired
	MahasiswaDao mahasiswaDao;
	
	@Override
	public Collection<Mahasiswa> listMahasiswa() throws Exception {
		return mahasiswaDao.listMahasiswa();
	}

	@Override
	public Mahasiswa geMahasiswa(int nim) throws Exception {
		return mahasiswaDao.getMahasiswa(nim);
	}

	@Override
	public void insertMahasiswa(Mahasiswa mahasiswa) throws Exception {
		mahasiswaDao.insertMahasiswa(mahasiswa);
	}

	@Override
	public void updateMahasiswa(Mahasiswa mahasiswa) throws Exception {
		mahasiswaDao.updateMahasiswa(mahasiswa);
	}

	@Override
	public void deleteMahasiswa(Mahasiswa mahasiswa) throws Exception {
		mahasiswaDao.deleteMahasiswa(mahasiswa);
	}

}
