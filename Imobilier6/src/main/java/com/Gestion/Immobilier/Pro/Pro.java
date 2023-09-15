package com.Gestion.Immobilier.Pro;

import com.Gestion.Immobilier.User.Address;
import com.Gestion.Immobilier.User.User;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Document(collection = "Pro")
public class Pro extends User {
	
    private String nomAgence;
	
	public Pro(String nomAgence, String fullName, String email, long tel, long whatsApp, String gender, Address address, String password) {
		super(fullName, email, tel, whatsApp, gender, address, password,"pro");
		this.setNomAgence(nomAgence);
	}
    
}
