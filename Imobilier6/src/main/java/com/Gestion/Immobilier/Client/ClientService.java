package com.Gestion.Immobilier.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherAnnouncement;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectAnnouncement;

public interface ClientService {

    Client addClient(Client client);

    List<Client> getAllClients();

    Optional<Client> getClientById(UUID id);

    int updateClient(UUID id, Client client);

    void deleteClient(UUID id);

    void addProjectAnnouncement(UUID id, ProjectAnnouncement annonce);

    void addOtherAnnouncement(String typeAnnonce,UUID id, OtherAnnouncement annonce);

    Announcements findAnnonceById(UUID ID, UUID id);

    Client deleteAnnouncement(UUID ID, UUID id);

    Client updateProjectAnnouncement(UUID ID, UUID id, ProjectAnnouncement project);

    Client updateOtherAnnouncement(UUID ID, UUID id, OtherAnnouncement other);

    List<Announcements> getAllAnnonces(UUID ID);

    List<Announcements> AllAnnonces();

    void saveAnnonce(UUID id,Announcements save);

    void deleteAnnonce(UUID id,UUID ID);

    List<Announcements> favoriteAnnonces(UUID id);
}
