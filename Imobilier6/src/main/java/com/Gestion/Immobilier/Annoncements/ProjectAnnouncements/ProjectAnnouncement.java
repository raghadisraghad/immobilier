package com.Gestion.Immobilier.Annoncements.ProjectAnnouncements;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectInfo.InfoDetaillees.*;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectInfo.InfodeBase.*;

import com.Gestion.Immobilier.Annoncements.coordonnees;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectAnnouncement extends Announcements {

    private String title;
    private address address;
    private prix prix;
    private typeDeBien typeDeBien;
    private general general;
    private particularite particularite;
    private String description;
    private coordonnees coordonnees;
    private byte[] photo;

    public ProjectAnnouncement(String title, address address, prix prix,typeDeBien typeDeBien,
                               general general, particularite particularite, String description, coordonnees coordonnees) {
        super("project");
        this.title = title;
        this.address = address;
        this.prix = prix;
        this.typeDeBien = typeDeBien;
        this.general = general;
        this.particularite = particularite;
        this.description = description;
        this.coordonnees = coordonnees;
//        this.photo = photo;
    }
}
