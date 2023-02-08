package com.example.gloQuora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	private String street;
	private String city;
	
	@OneToOne
	private UserDetails userId;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public UserDetails getUserid() {
		return userId;
	}

	public void setUserid(UserDetails userid) {
		this.userId = userid;
	}
}
