package com.Gestion.Immobilier.Annoncements.Annonce;

import lombok.Data;

import java.util.UUID;

@Data
public class Announcements {

    private UUID id;
    private String typeAnnonce;

    public Announcements(String typeAnnonce){
        this.id = UUID.randomUUID();
        this.typeAnnonce=typeAnnonce;
    }

}