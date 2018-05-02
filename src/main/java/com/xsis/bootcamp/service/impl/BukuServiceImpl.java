package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.BukuDao;
import com.xsis.bootcamp.model.Buku;
import com.xsis.bootcamp.service.BukuService;

@Transactional
@Service
public class BukuServiceImpl implements BukuService{
	@Autowired
	private BukuDao bukuDao;

	@Override
	public void insert(Buku buku) throws Exception {
		bukuDao.insert(buku);
		
	}

	@Override
	public void update(Buku buku) throws Exception {
		bukuDao.update(buku);
		
	}

	@Override
	public void delete(Buku buku) throws Exception {
		bukuDao.delete(buku);
		
	}

	@Override
	public Collection<Buku> listAll() throws Exception {
		return bukuDao.listAll();
	}

	@Override
	public Buku get(Long idBuku) throws Exception {
		return bukuDao.get(idBuku);
	}
	
	

}
