package com.Gestion.Immobilier.Agence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherAnnouncement;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectAnnouncement;

public interface AgenceService {

    Agence addAgence(Agence agence);

    List<Agence> getAllAgences();

    Optional<Agence> getAgenceById(UUID id);

    int updateAgence(UUID id, Agence agence);

    void deleteAgence(UUID id);
    void addProjectAnnouncement(UUID id, ProjectAnnouncement annonce);

    void addOtherAnnouncement(String typeAnnonce,UUID id, OtherAnnouncement annonce);

    Announcements findAnnonceById(UUID ID, UUID id);

    Agence deleteAnnouncement(UUID ID, UUID id);

    Agence updateProjectAnnouncement(UUID ID, UUID id, ProjectAnnouncement project);

    Agence updateOtherAnnouncement(UUID ID, UUID id, OtherAnnouncement other);

    List<Announcements> getAllAnnonces(UUID ID);

    List<Announcements> AllAnnonces();
    void saveAnnonce(UUID id,Announcements save);

    void deleteAnnonce(UUID id,UUID ID);

    List<Announcements> favoriteAnnonces(UUID id);

}
