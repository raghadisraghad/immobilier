package com.Gestion.Immobilier.Annoncements.OtherAnnouncements;

import com.Gestion.Immobilier.Agence.AgenceService;
import com.Gestion.Immobilier.Client.ClientService;
import com.Gestion.Immobilier.Pro.ProService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OtherServiceImpl implements OtherService {

    private final ProService proService;
    private final ClientService clientService;
    private final AgenceService agenceService;

    public OtherServiceImpl(ProService proService, ClientService clientService, AgenceService agenceService) {
        this.proService = proService;
        this.clientService = clientService;
        this.agenceService = agenceService;
    }

    public void addOther(String typeAnnonce,String type, UUID id, OtherAnnouncement annonce){
        switch (type) {
            case "pro" -> proService.addOtherAnnouncement(typeAnnonce,id, annonce);
            case "client" -> clientService.addOtherAnnouncement(typeAnnonce,id, annonce);
            case "agence" -> agenceService.addOtherAnnouncement(typeAnnonce,id, annonce);
        }
    }

    public void updateOther(String type,UUID ID,UUID id,OtherAnnouncement annonce){
        switch (type) {
            case "pro" -> proService.updateOtherAnnouncement(ID, id, annonce);
            case "client" -> clientService.updateOtherAnnouncement(ID, id, annonce);
            case "agence" -> agenceService.updateOtherAnnouncement(ID, id, annonce);
        }
    }

}
