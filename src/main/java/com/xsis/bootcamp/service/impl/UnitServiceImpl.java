package com.xsis.bootcamp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.UnitDao;
import com.xsis.bootcamp.model.Unit;
import com.xsis.bootcamp.service.UnitService;

@Transactional
@Service
public class UnitServiceImpl implements UnitService {
	@Autowired
	private UnitDao unitDao;

	@Override
	public void insert(Unit unit) throws Exception {
		unitDao.insert(unit);
	}

	@Override
	public void update(Unit unit) throws Exception {
		unitDao.update(unit);
	}

	@Override
	public void delete(Unit unit) throws Exception {
		unitDao.delete(unit);
	}

	@Override
	public Collection<Unit> listAll() throws Exception {
		return unitDao.listAll();
	}

	@Override
	public Unit get(Long idUnit) throws Exception {
		return unitDao.get(idUnit);
	}

}
