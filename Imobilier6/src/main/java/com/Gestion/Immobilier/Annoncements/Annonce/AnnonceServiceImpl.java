package com.Gestion.Immobilier.Annoncements.Annonce;

import com.Gestion.Immobilier.Agence.AgenceService;
import com.Gestion.Immobilier.Client.ClientService;
import com.Gestion.Immobilier.Pro.ProService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    private final ProService proService;
    private final ClientService clientService;
    private final AgenceService agenceService;

    public AnnonceServiceImpl(ProService proService, ClientService clientService, AgenceService agenceService) {
        this.proService = proService;
        this.clientService = clientService;
        this.agenceService = agenceService;
    }

    public void delete(String type,UUID ID,UUID id){
        switch (type) {
            case "pro" -> proService.deleteAnnouncement(ID, id);
            case "client" -> clientService.deleteAnnouncement(ID, id);
            case "agence" -> agenceService.deleteAnnouncement(ID, id);
        }
    }

    public List<Announcements> getAll(String type, UUID ID) {
        return switch (type) {
            case "pro" -> proService.getAllAnnonces(ID);
            case "client" -> clientService.getAllAnnonces(ID);
            case "agence" -> agenceService.getAllAnnonces(ID);
            default -> null;
        };
    }

    public Announcements getAllById(String type, UUID ID,UUID id) {
        return switch (type) {
            case "pro" -> proService.findAnnonceById(ID,id);
            case "client" -> clientService.findAnnonceById(ID,id);
            case "agence" -> agenceService.findAnnonceById(ID,id);
            default -> null;
        };
    }

    public List<Announcements> All(){
        List<Announcements> proAnnonces = proService.AllAnnonces();
        List<Announcements> clientAnnonces = clientService.AllAnnonces();
        List<Announcements> agenceAnnonces = agenceService.AllAnnonces();

        proAnnonces.addAll(clientAnnonces);
        proAnnonces.addAll(agenceAnnonces);
        return proAnnonces;
    }

    public void saveFavorite(String type,UUID id,UUID ID) {
        Announcements found = null;
        for (Announcements save : All()) {
            if (save.getId().equals(ID)) {
                found = save ;break;
            }
        }
        if (found != null) {
            switch (type) {
                case "pro" -> proService.saveAnnonce(id, found);
                case "client" -> clientService.saveAnnonce(id, found);
                case "agence" -> agenceService.saveAnnonce(id, found);
            }
        }
    }

    public void deleteFavorite(String type,UUID id,UUID ID) {
        switch (type) {
            case "pro" -> proService.deleteAnnonce(id, ID);
            case "client" -> clientService.deleteAnnonce(id, ID);
            case "agence" -> agenceService.deleteAnnonce(id, ID);
        }
    }

    public List<Announcements> savedFavorites(String type,UUID ID) {
        return switch (type) {
            case "pro" -> proService.favoriteAnnonces(ID);
            case "client" -> clientService.favoriteAnnonces(ID);
            case "agence" -> agenceService.favoriteAnnonces(ID);
            default -> null;
        };
    }

}
