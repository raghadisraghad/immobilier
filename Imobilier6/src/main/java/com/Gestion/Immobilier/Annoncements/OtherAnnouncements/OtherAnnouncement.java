package com.Gestion.Immobilier.Annoncements.OtherAnnouncements;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherInfo.InfoDetaillees.*;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherInfo.InfodeBases.*;

import com.Gestion.Immobilier.Annoncements.coordonnees;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OtherAnnouncement extends Announcements {

	private String title;
    private address_O address_O;
    private prix_O prix_O;
    private typeDeBien_O typeDeBien_O;
    private exterieur_O exterieur_O;
    private general_O general_O;
    private interieur_O interieur_O;
    private particularite_O particularite_O;
    private String description;
    private coordonnees coordonnees;
    private byte[] photo;


    public OtherAnnouncement(String typeAnnonce, String title, address_O address_O, prix_O prix_O, typeDeBien_O typeDeBien_O,
                             interieur_O interieur_O, exterieur_O exterieur_O, general_O general_O, particularite_O particularite_O,
                             String description, coordonnees coordonnees) {
        super(typeAnnonce);
        this.title=title;
        this.address_O = address_O;
        this.prix_O = prix_O;
        this.typeDeBien_O = typeDeBien_O;
        this.general_O = general_O;
        this.exterieur_O = exterieur_O;
        this.interieur_O = interieur_O;
        this.particularite_O = particularite_O;
        this.description = description;
        this.coordonnees = coordonnees;
//        this.photo = photo;
    }
}
