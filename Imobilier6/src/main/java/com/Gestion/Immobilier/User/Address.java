package com.Gestion.Immobilier.User;

import lombok.Data;

@Data
public class Address {
	
	private String address;
	private String city;
	private int zipCode;
	
	public Address(String address, String city, int zipCode) {
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
	}
}
