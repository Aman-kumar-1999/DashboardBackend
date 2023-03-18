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
@Table(name="Health_Dashboard_Portal")
public class HealthDashboardPortal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="DateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datetime;
	
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
	
	@Column(name="Service_STATUS")
	private String serviceStatus;
	
	@Column(name="Threshold_Mount_Point")
	private String thresholdMountPoint;
	
	@Column(name="Clean_UP_Mount_Point")
	private String cleanUpMountPoint;
	
	@Column(name="MOUNT_POINT_UTILIZATION")
	private String mountPointUtilization;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public LocalDate getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
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

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getThresholdMountPoint() {
		return thresholdMountPoint;
	}

	public void setThresholdMountPoint(String thresholdMountPoint) {
		this.thresholdMountPoint = thresholdMountPoint;
	}

	public String getCleanUpMountPoint() {
		return cleanUpMountPoint;
	}

	public void setCleanUpMountPoint(String cleanUpMountPoint) {
		this.cleanUpMountPoint = cleanUpMountPoint;
	}

	public String getMountPointUtilization() {
		return mountPointUtilization;
	}

	public void setMountPointUtilization(String mountPointUtilization) {
		this.mountPointUtilization = mountPointUtilization;
	}

	public HealthDashboardPortal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthDashboardPortal(Long id, LocalDate datetime, String healthDashboard, String applicationName,
			String serverIp, String frequency, String infoupdatedBy, String serviceStatus, String thresholdMountPoint,
			String cleanUpMountPoint, String mountPointUtilization) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.healthDashboard = healthDashboard;
		this.applicationName = applicationName;
		this.serverIp = serverIp;
		this.frequency = frequency;
		this.infoupdatedBy = infoupdatedBy;
		this.serviceStatus = serviceStatus;
		this.thresholdMountPoint = thresholdMountPoint;
		this.cleanUpMountPoint = cleanUpMountPoint;
		this.mountPointUtilization = mountPointUtilization;
	}

	
	
	
	

}
