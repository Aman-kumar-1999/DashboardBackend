package com.codea2z.dashboard.entity;



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
@Table(name="Health_Dashboard_Infra")
public class HealthDashboardInfra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="DateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datatime;
	
	@Column(name="Health_Dashboard")
	private String healthDashboard;
	
	@Column(name="Application_Name")
	private String applicationName;
	
	@Column(name="Server_IP")
	private String serverIp;
	
	@Column(name="Frequency")
	private String frequency;
	
	@Column(name="Info_updated_by")
	private String infoupdatedBy;
	
	@Column(name="CPU")
	private String upu;
	
	@Column(name="Memory")
	private String memory;
	
	@Column(name="Disk_UTILIZATION")
	private String diskUtilization;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public LocalDate getDatatime() {
		return datatime;
	}

	public void setDatatime(LocalDate datatime) {
		this.datatime = datatime;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getHealthDashboard() {
		return healthDashboard;
	}

	public void setHealthDashboard(String healthDashboard) {
		this.healthDashboard = healthDashboard;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getServerId() {
		return serverIp;
	}

	public void setServerId(String serverId) {
		this.serverIp = serverId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getInfoupdatedBy() {
		return infoupdatedBy;
	}

	public void setInfoupdatedBy(String infoupdatedBy) {
		this.infoupdatedBy = infoupdatedBy;
	}

	public String getUpu() {
		return upu;
	}

	public void setUpu(String upu) {
		this.upu = upu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getDiskUtilization() {
		return diskUtilization;
	}

	public void setDiskUtilization(String diskUtilization) {
		this.diskUtilization = diskUtilization;
	}

	public HealthDashboardInfra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthDashboardInfra(Long id, LocalDate datatime, String healthDashboard, String applicationName, String serverIp,
			String frequency, String infoupdatedBy, String upu, String memory, String diskUtilization) {
		super();
		this.id = id;
		this.datatime = datatime;
		this.healthDashboard = healthDashboard;
		this.applicationName = applicationName;
		this.serverIp = serverIp;
		this.frequency = frequency;
		this.infoupdatedBy = infoupdatedBy;
		this.upu = upu;
		this.memory = memory;
		this.diskUtilization = diskUtilization;
	}

	


	
	
	
	
	
	

}
