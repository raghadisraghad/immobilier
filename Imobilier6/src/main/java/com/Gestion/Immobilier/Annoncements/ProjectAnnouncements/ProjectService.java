package com.Gestion.Immobilier.Annoncements.ProjectAnnouncements;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ProjectService {

    void addProject(String type, UUID id, ProjectAnnouncement annonce);

    void updateProject(String type, UUID ID, UUID id, ProjectAnnouncement annonce);

}

