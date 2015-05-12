package com.ikonsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facebookChannel")
public class FacebookChannel  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="AppID")
	private String AppID;
	
	@Column(name="AppSecrit")
	private String AppSecrit;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppID() {
		return AppID;
	}

	public void setAppID(String appID) {
		AppID = appID;
	}

	public String getAppSecrit() {
		return AppSecrit;
	}

	public void setAppSecrit(String appSecrit) {
		AppSecrit = appSecrit;
	}

	

	
}
