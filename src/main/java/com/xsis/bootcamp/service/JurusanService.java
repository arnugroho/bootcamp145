package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Jurusan;


public interface JurusanService {
	public Collection<Jurusan> listJurusan() throws Exception;
	public void insertJurusan(Jurusan jurusan) throws Exception;
	public void updateJurusan(Jurusan jurusan) throws Exception;
	public void deleteJurusan(Jurusan jurusan) throws Exception;
}
