package com.example.gloQuora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "geo")
public class Geo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long geoId;
	private String latitude;
	private String longitude;

	@OneToOne
	private UserDetails userId;

	public Geo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getGeoId() {
		return geoId;
	}

	public void setGeoId(Long geoId) {
		this.geoId = geoId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

}
