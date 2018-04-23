package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "mahasiswa")
public class Mahasiswa {
	private int nim;
	private String namaMahasiswa;
	private String alamat;
	private Jurusan jurusanDesc;
	private Fakultas fakultasDesc;

	@GeneratedValue
	@Id
	@Column(name = "nim", length = 15, nullable = false)
	public int getNim() {
		return nim;
	}

	public void setNim(int nim) {
		this.nim = nim;
	}

	@Column(name = "nama_mahasiswa", length = 50, nullable = false)
	public String getNamaMahasiswa() {
		return namaMahasiswa;
	}

	public void setNamaMahasiswa(String namaMahasiswa) {
		this.namaMahasiswa = namaMahasiswa;
	}

	@Column(name = "alamat", length = 100, nullable = false)
	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@ManyToOne
	@JoinColumn(name = "jurusan", updatable = false, insertable = false)
	public Jurusan getJurusanDesc() {
		return jurusanDesc;
	}

	public void setJurusanDesc(Jurusan jurusanDesc) {
		this.jurusanDesc = jurusanDesc;
	}

	@ManyToOne
	@JoinColumn(name = "fakultas", updatable = false, insertable = false)
	public Fakultas getFakultasDesc() {
		return fakultasDesc;
	}

	public void setFakultasDesc(Fakultas fakultasDesc) {
		this.fakultasDesc = fakultasDesc;
	}

}
