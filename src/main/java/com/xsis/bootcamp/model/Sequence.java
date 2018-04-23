package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_sequence")
public class Sequence {
	@Column(name="seq_name")
	@Id
	private String seqName;
	@Column(name="seq_val")
	private Long seqVal;
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	public Long getSeqVal() {
		return seqVal;
	}
	public void setSeqVal(Long seqVal) {
		this.seqVal = seqVal;
	}
}
