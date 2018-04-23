package com.xsis.bootcamp.dao;

import java.util.Collection;

import com.xsis.bootcamp.model.Fakultas;

public interface FakultasDao {

	public Collection<Fakultas> listFakultas() throws Exception;

	public void insertFakultas(Fakultas fakultas) throws Exception;

	public void updateFakultas(Fakultas fakultas) throws Exception;

	public void deleteFakultas(Fakultas fakultas) throws Exception;

}
