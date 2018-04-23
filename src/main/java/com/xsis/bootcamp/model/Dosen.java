package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name =  "dosen")
public class Dosen {
	private int nikDosen;
	private String namaDosen;
	private String alamat;
	private int fakultas;
	private int jurusan;
	private int matkul;
	private Fakultas fakultasDesc;
	private Jurusan jurusanDesc;
	private Matkul matkulDesc;
	
	
	@GeneratedValue
	@Id
	@Column(name = "nikdosen", length = 11, nullable = false)
	public int getNikDosen() {
		return nikDosen;
	}
	public void setNikDosen(int nikDosen) {
		this.nikDosen = nikDosen;
	}
	
	@Column(name = "namadosen", length = 45, nullable = false)
	public String getNamaDosen() {
		return namaDosen;
	}
	public void setNamaDosen(String namaDosen) {
		this.namaDosen = namaDosen;
	}
	
	@Column(name = "alamat", length = 60, nullable = false)
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	@Column(name="fakultas", length = 11)
	public int getFakultas() {
		return fakultas;
	}
	public void setFakultas(int fakultas) {
		this.fakultas = fakultas;
	}
	
	@Column(name="jurusan", length = 11)
	public int getJurusan() {
		return jurusan;
	}
	public void setJurusan(int jurusan) {
		this.jurusan = jurusan;
	}
	
	@Column(name="matkul", length = 11)
	public int getMatkul() {
		return matkul;
	}
	public void setMatkul(int matkul) {
		this.matkul = matkul;
	}
	
	@ManyToOne
	@JoinColumn(name = "fakultas", updatable = false, insertable = false)
	public Fakultas getFakultasDesc() {
		return fakultasDesc;
	}
	public void setFakultasDesc(Fakultas fakultasDesc) {
		this.fakultasDesc = fakultasDesc;
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
	@JoinColumn(name = "matkul", updatable = false, insertable = false)
	public Matkul getMatkulDesc() {
		return matkulDesc;
	}
	public void setMatkulDesc(Matkul matkulDesc) {
		this.matkulDesc = matkulDesc;
	}
	
}
