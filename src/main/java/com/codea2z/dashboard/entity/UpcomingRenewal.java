package com.wipro.dashboard.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Upcoming_Renewal")
public class UpcomingRenewal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Application_Infra")
	private String applicationInfra;
	
	@Column(name="Renewal_Type")
	private String renewalType;
	
	@Column(name="Due_Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueData;
	
	@Column(name="Owner")
	private String owner;
	
	@Column(name="Info_updated_by")
	private String infoUpdateBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicationInfra() {
		return applicationInfra;
	}

	public void setApplicationInfra(String applicationInfra) {
		this.applicationInfra = applicationInfra;
	}

	public String getRenewalType() {
		return renewalType;
	}

	public void setRenewalType(String renewalType) {
		this.renewalType = renewalType;
	}

	

	public LocalDate getDueData() {
		return dueData;
	}

	public void setDueData(LocalDate dueData) {
		this.dueData = dueData;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getInfoUpdateBy() {
		return infoUpdateBy;
	}

	public void setInfoUpdateBy(String infoUpdateBy) {
		this.infoUpdateBy = infoUpdateBy;
	}

	public UpcomingRenewal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpcomingRenewal(Long id, String applicationInfra, String renewalType, LocalDate dueData, String owner,
			String infoUpdateBy) {
		super();
		this.id = id;
		this.applicationInfra = applicationInfra;
		this.renewalType = renewalType;
		this.dueData = dueData;
		this.owner = owner;
		this.infoUpdateBy = infoUpdateBy;
	}

	
	
	
	
	
	

}
