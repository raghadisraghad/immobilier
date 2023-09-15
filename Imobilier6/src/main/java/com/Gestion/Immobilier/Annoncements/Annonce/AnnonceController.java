package com.Gestion.Immobilier.Annoncements.Annonce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/annonce")
@RestController
public class AnnonceController {

	@Autowired
    private AnnonceService annonceService;

    @DeleteMapping("/{type}/{ID}/{id}")
    public void delete(@PathVariable("type") String type,@PathVariable("ID") UUID ID,@PathVariable("id") UUID id) {
        annonceService.delete(type,ID,id);
    }

    @GetMapping("/{type}/{id}")
    public List<Announcements> annonces(@PathVariable("type") String type, @PathVariable("id") UUID id) {
        return annonceService.getAll(type,id);
    }

    @GetMapping("/{type}/{ID}/{id}")
    public Announcements annonceById(@PathVariable("type") String type, @PathVariable("ID") UUID ID, @PathVariable("id") UUID id) {
        return annonceService.getAllById(type,ID,id);
    }

    @GetMapping("/")
    public List<Announcements> all(){
        return annonceService.All();
    }

    @DeleteMapping("/f/{type}/{ID}/{id}")
    public void deleteFavorite(@PathVariable("type") String type,@PathVariable("ID") UUID ID,@PathVariable("id") UUID id) {
        annonceService.deleteFavorite(type,ID,id);
    }

    @PostMapping("/f/{type}/{ID}/{id}")
    public void addFavorite(@PathVariable("type") String type,@PathVariable("ID") UUID ID, @PathVariable("id") UUID id) {
        annonceService.saveFavorite(type,ID,id);
    }

    @GetMapping("/f/{type}/{ID}")
    public List<Announcements> favorites(@PathVariable("type") String type, @PathVariable("ID") UUID ID) {
        return annonceService.savedFavorites(type,ID);
    }

}