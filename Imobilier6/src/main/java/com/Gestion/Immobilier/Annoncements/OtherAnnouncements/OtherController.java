package com.Gestion.Immobilier.Annoncements.OtherAnnouncements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/other")
@RestController
public class OtherController {

	@Autowired
    private OtherService otherService;

    @PostMapping("/{annonce}/{type}/{id}")
    public void add(@PathVariable("annonce") String annonce,@PathVariable("type") String type,@PathVariable("id") UUID id,@RequestBody OtherAnnouncement title) {
        otherService.addOther(annonce,type,id,title);
    }

    @PutMapping("/{type}/{ID}/{id}")
    public void update(@PathVariable("type") String type,@PathVariable("ID") UUID ID,@PathVariable("id") UUID id,@RequestBody OtherAnnouncement title) {
        otherService.updateOther(type,ID,id,title);
    }

}