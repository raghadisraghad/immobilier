package com.Gestion.Immobilier.Annoncements.Annonce;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AnnonceService {

    void delete(String type, UUID ID, UUID id);

    List<Announcements> getAll(String type, UUID ID);

    Announcements getAllById(String type, UUID ID, UUID id);

    List<Announcements> All();

    void saveFavorite(String type, UUID id, UUID ID);

    void deleteFavorite(String type, UUID id, UUID ID);

    List<Announcements> savedFavorites(String type, UUID ID);
}

