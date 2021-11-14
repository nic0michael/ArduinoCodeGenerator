package com.zs6bvr.arduino.code.generator.entities;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;



import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;

import com.zs6bvr.arduino.code.generator.dtos.UploadFeatureRequest;


@Entity
public class Contributor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contributorsId;
	
	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@Column(name="contributor_guid", nullable = false, updatable = false, length=128)
	private String contributorsGuid;

	@Column(name="contributor", nullable = false, updatable = false, length=128)
	private String contributorsName;
	
	@Column(name="contributor_blog", nullable = false, updatable = false, length=128)
	private String contributorsBlogPage;

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getContributorsGuid() {
		return contributorsGuid;
	}

	public void setContributorsGuid(String contributorsGuid) {
		this.contributorsGuid = contributorsGuid;
	}

	public String getContributorsName() {
		return contributorsName;
	}

	public void setContributorsName(String contributorsName) {
		this.contributorsName = contributorsName;
	}

	public String getContributorsBlogPage() {
		return contributorsBlogPage;
	}

	public void setContributorsBlogPage(String contributorsBlogPage) {
		this.contributorsBlogPage = contributorsBlogPage;
	}

	@Override
	public String toString() {
		return "Contributor [contributorsId=" + contributorsId + ", dateCreated=" + dateCreated + ", contributorsGuid="
				+ contributorsGuid + ", contributorsName=" + contributorsName + ", contributorsBlogPage="
				+ contributorsBlogPage + "]";
	}

	
	
}
