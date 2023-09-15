package com.Gestion.Immobilier.Annoncements.ProjectAnnouncements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/project")
@RestController
public class ProjectController {

	@Autowired
    private ProjectService projectService;

    @PostMapping("/{type}/{id}")
    public void add(@PathVariable("type") String type,@PathVariable("id") UUID id,@RequestBody ProjectAnnouncement annonce) {
        projectService.addProject(type,id,annonce);
    }

    @PutMapping("/{type}/{ID}/{id}")
    public void update(@PathVariable("type") String type,@PathVariable("ID") UUID ID,@PathVariable("id") UUID id,
                       @RequestBody ProjectAnnouncement annonce) {
        projectService.updateProject(type,ID,id,annonce);
    }

}