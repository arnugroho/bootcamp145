package com.xsis.bootcamp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.xsis.bootcamp.model.common.CommonModel;

@Entity
@Table(name = Event.TABLE_NAME)
public class Event extends CommonModel {
	private static final long serialVersionUID = 2799197946423535481L;
	public static final String TABLE_NAME = "t_event";
	@Id
	@Column(name = "id", length = 11, nullable = false)
	@TableGenerator(name = Event.TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = Event.TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = Event.TABLE_NAME)
	private int id;
	@Column(name = "code", length = 50, nullable = false)
	private String code;
	@Column(name = "event_name", length = 255, nullable = false)
	private String eventName;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "place", length = 255)
	private String place;
	@Column(name = "budget", length = 50)
	private Long budget;
	@Column(name = "request_by", length = 11, nullable = false)
	private int requestBy;
	@Column(name = "request_date", nullable = false)
	private Date requestDate;
	@Column(name = "approved_by", length = 11, nullable = false)
	private int approvedBy;
	@Column(name = "approved_date")
	private Date approvedDate;
	@Column(name = "assign_to", length = 11)
	private int assignTo;
	@Column(name = "close_date")
	private Date closeDate;
	@Column(name = "note", length = 255)
	private String note;
	@Column(name = "status", length = 255)
	private int status;
	@Column(name = "reject_reason", length = 255)
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

	public String getEventname() {
		return eventName;
	}

	public void setEventname(String eventname) {
		this.eventName = eventname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public int getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(int requestBy) {
		this.requestBy = requestBy;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public int getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public int getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(int assignTo) {
		this.assignTo = assignTo;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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
