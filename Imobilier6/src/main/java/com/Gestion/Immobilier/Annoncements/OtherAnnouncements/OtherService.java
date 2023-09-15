package com.Gestion.Immobilier.Annoncements.OtherAnnouncements;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface OtherService {

    void addOther(String typeAnnonce,String type, UUID id, OtherAnnouncement annonce);

    void updateOther(String type, UUID ID, UUID id, OtherAnnouncement annonce);

}

