package com.codea2z.dashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Health_Dashboard_App_OEM")
public class HealthDashboardAppOem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Heatlh_Dasboard")
	private	String healthDasboard; 	
	
	@Column(name="Application_Name")
	private String applicationName;
	
	@Column(name="Server_IP")
	private String serverIp;
	
	@Column(name="L1")
	private String l1;
	
	@Column(name="L2")
	private String l2;
	
	@Column(name="Application_OEM")
	private String applicationOem;
	
	@Column(name="OEM_Support_Status")
	private String oemSupportStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHealthDasboard() {
		return healthDasboard;
	}

	public void setHealthDasboard(String healthDasboard) {
		this.healthDasboard = healthDasboard;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getL1() {
		return l1;
	}

	public void setL1(String l1) {
		this.l1 = l1;
	}

	public String getL2() {
		return l2;
	}

	public void setL2(String l2) {
		this.l2 = l2;
	}

	public String getApplicationOem() {
		return applicationOem;
	}

	public void setApplicationOem(String applicationOem) {
		this.applicationOem = applicationOem;
	}

	public String getOemSupportStatus() {
		return oemSupportStatus;
	}

	public void setOemSupportStatus(String oemSupportStatus) {
		this.oemSupportStatus = oemSupportStatus;
	}

	public HealthDashboardAppOem() {
		
	}

	public HealthDashboardAppOem(Long id, String healthDasboard, String applicationName, String serverIp, String l1,
			String l2, String applicationOem, String oemSupportStatus) {
		super();
		this.id = id;
		this.healthDasboard = healthDasboard;
		this.applicationName = applicationName;
		this.serverIp = serverIp;
		this.l1 = l1;
		this.l2 = l2;
		this.applicationOem = applicationOem;
		this.oemSupportStatus = oemSupportStatus;
	}
	
}
