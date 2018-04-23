package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Fakultas;

public interface FakultasService {

	public Collection<Fakultas> listFakultas() throws Exception;

	public Fakultas getFakultas(int idFakultas) throws Exception;

	public void insertFakultas(Fakultas fakultas) throws Exception;

	public void updateFakultas(Fakultas fakultas) throws Exception;

	public void deleteFakultas(Fakultas fakultas) throws Exception;

}
