package com.Gestion.Immobilier.Client;

import com.Gestion.Immobilier.User.Address;
import com.Gestion.Immobilier.User.User;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(collection = "Client")
public class Client extends User {

	public Client(String fullName, String email, long tel, long whatsApp, String gender, Address address, String password) {
		super(fullName, email, tel, whatsApp, gender, address, password,"client");
	}
}
