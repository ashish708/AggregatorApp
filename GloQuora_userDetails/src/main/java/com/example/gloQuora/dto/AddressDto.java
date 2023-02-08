package com.example.gloQuora.dto;

public class AddressDto {

	private Long addressId;
	private String street;
	private String city;
	private GeoDto geo;

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

	public GeoDto getGeo() {
		return geo;
	}

	public void setGeo(GeoDto geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "AddressDto [addressId=" + addressId + ", street=" + street + ", city=" + city + "]";
	}

}
