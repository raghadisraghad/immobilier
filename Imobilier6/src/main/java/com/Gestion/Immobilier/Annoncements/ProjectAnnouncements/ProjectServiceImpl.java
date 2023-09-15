package com.Gestion.Immobilier.Annoncements.ProjectAnnouncements;

import com.Gestion.Immobilier.Agence.AgenceService;
import com.Gestion.Immobilier.Client.ClientService;
import com.Gestion.Immobilier.Pro.ProService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProService proService;
    private final ClientService clientService;
    private final AgenceService agenceService;

    public ProjectServiceImpl(ProService proService, ClientService clientService, AgenceService agenceService) {
        this.proService = proService;
        this.clientService = clientService;
        this.agenceService = agenceService;
    }

    public void addProject(String type, UUID id,ProjectAnnouncement annonce){
        switch (type) {
            case "pro" -> proService.addProjectAnnouncement(id, annonce);
            case "client" -> clientService.addProjectAnnouncement(id, annonce);
            case "agence" -> agenceService.addProjectAnnouncement(id, annonce);
        }
    }
    public void updateProject(String type,UUID ID,UUID id,ProjectAnnouncement annonce){
        switch (type) {
            case "pro" -> proService.updateProjectAnnouncement(ID, id, annonce);
            case "client" -> clientService.updateProjectAnnouncement(ID, id, annonce);
            case "agence" -> agenceService.updateProjectAnnouncement(ID, id, annonce);
        }
    }

}
