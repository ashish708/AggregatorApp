package com.example.gloQuora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "userDetails")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	private String userName;
	private String email;
	private String phone;

	@OneToOne(mappedBy = "userId")
	private Address address;
	
	@OneToOne(mappedBy = "userId")
	private Geo geo;
	
	@OneToOne(mappedBy = "userId")
	private Company company;

	public UserDetails() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

//	public UserDetails(Long userId, String name, String userName, String email, String phone, Address address, Geo geo,
//			Company company) {
//		super();
//		this.userId = userId;
//		this.name = name;
//		this.userName = userName;
//		this.email = email;
//		this.phone = phone;
//		this.address = address;
//		this.geo = geo;
//		this.company = company;
//	}
//
//	@Override
//	public String toString() {
//		return "UserDetails [userId=" + userId + ", name=" + name + ", userName=" + userName + ", email=" + email
//				+ ", phone=" + phone + ", address=" + address + ", geo=" + geo + ", company=" + company + "]";
//	}

}
