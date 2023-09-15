package com.Gestion.Immobilier.Agence;

import com.Gestion.Immobilier.User.Address;
import com.Gestion.Immobilier.User.User;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(collection = "Agence")
public class Agence extends User {

    private String nomAgence;
	
	public Agence(String nomAgence, String fullName, String email, long tel, long whatsApp, String gender, Address address, String password) {
		super(fullName, email, tel, whatsApp, gender, address, password,"agence");
		this.setNomAgence(nomAgence);
	}
}