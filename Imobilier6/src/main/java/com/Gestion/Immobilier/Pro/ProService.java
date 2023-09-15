package com.Gestion.Immobilier.Pro;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherAnnouncement;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectAnnouncement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProService {

    Pro addPro(Pro pro);

    List<Pro> getAllPros();

    Optional<Pro> getProById(UUID id);

    int updatePro(UUID id, Pro pro);

    void deletePro(UUID id);
    void addProjectAnnouncement(UUID id,ProjectAnnouncement annonce);

    void addOtherAnnouncement(String typeAnnonce,UUID id, OtherAnnouncement annonce);

    Announcements findAnnonceById(UUID ID, UUID i);

    Pro deleteAnnouncement(UUID ID, UUID id);

    Pro updateProjectAnnouncement(UUID ID, UUID id, ProjectAnnouncement project);

    Pro updateOtherAnnouncement(UUID ID, UUID id, OtherAnnouncement other);

    List<Announcements> getAllAnnonces(UUID ID);

    List<Announcements> AllAnnonces();

    void saveAnnonce(UUID id,Announcements save);

    void deleteAnnonce(UUID id,UUID ID);

    List<Announcements> favoriteAnnonces(UUID id);


}
