package com.xsis.bootcamp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xsis.bootcamp.model.common.CommonModel;

@Entity
@Table(name = Design.TABLE_NAME)
public class Design extends CommonModel {
	private static final long serialVersionUID = -410528525061506841L;
	public static final String TABLE_NAME = "t_design";

	@Id
	@Column(name = "id", length = 11, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = Design.TABLE_NAME)
	@TableGenerator(name = Design.TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = Design.TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private int id;

	@Column(name = "code", length = 50, nullable = false)
	private String code;

	@Column(name = "title_header", length = 255, nullable = false)
	private String titleHeader;

	@Temporal(TemporalType.DATE)
	@Column(name = "request_date")
	private Date requestDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "approved_date")
	private Date approvedDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "closed_date")
	private Date closedDate;

	@Column(name = "note", length = 255, nullable = true)
	private String note;

	@Column(name = "status", length = 1, nullable = true)
	private int status;

	@Column(name = "reject_reason", length = 255, nullable = true)
	private String rejectReason;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitleHeader() {
		return titleHeader;
	}

	public void setTitleHeader(String titleHeader) {
		this.titleHeader = titleHeader;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
}
