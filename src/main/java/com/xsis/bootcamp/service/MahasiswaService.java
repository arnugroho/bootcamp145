package com.xsis.bootcamp.service;

import java.util.Collection;

import com.xsis.bootcamp.model.Mahasiswa;

public interface MahasiswaService {
	public Collection<Mahasiswa> listMahasiswa () throws Exception;
	public Mahasiswa geMahasiswa (int nim) throws Exception;
	public void insertMahasiswa (Mahasiswa mahasiswa) throws Exception;
	public void updateMahasiswa (Mahasiswa mahasiswa) throws Exception;
	public void deleteMahasiswa (Mahasiswa mahasiswa) throws Exception;
	
}
