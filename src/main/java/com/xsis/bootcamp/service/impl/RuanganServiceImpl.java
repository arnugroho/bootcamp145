package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.RuanganDao;
import com.xsis.bootcamp.model.Ruangan;
import com.xsis.bootcamp.service.RuanganService;

@Service
@Transactional
public class RuanganServiceImpl extends HibernateDaoSupport implements RuanganService {
	@Autowired
	private RuanganDao ruanganDao;
	
	
	@Override
	public Collection<Ruangan> listRuangan() throws Exception {
		// TODO Auto-generated method stub
		return ruanganDao.listRuangan();
	}

	@Override
	public void insertRuangan(Ruangan ruangan) throws Exception {
		// TODO Auto-generated method stub
			ruanganDao.insertRuangan(ruangan);
	}

	@Override
	public void updateRuangan(Ruangan ruangan) throws Exception {
		// TODO Auto-generated method stub
		ruanganDao.updateRuangan(ruangan);
	}

	@Override
	public void deleteRuangan(Ruangan ruangan) throws Exception {
		// TODO Auto-generated method stub
		ruanganDao.deleteRuangan(ruangan);
	}

	@Override
	public Ruangan getRuangan(int idruangan) throws Exception {
		// TODO Auto-generated method stub
		return ruanganDao.getRuangan(idruangan);
	}

}
