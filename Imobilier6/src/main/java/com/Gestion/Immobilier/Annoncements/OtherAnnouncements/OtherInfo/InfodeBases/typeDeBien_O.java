package com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherInfo.InfodeBases;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class typeDeBien_O {

    private String NomProject ;
    private String typeDeBien ;
    private String sousType ;
    private String marche;
    private Date disponibilite ;
    private Date disponibleLe ;
}
