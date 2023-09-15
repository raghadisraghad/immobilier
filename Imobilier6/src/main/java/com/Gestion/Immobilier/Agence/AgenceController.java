package com.Gestion.Immobilier.Agence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/agence")
@RestController
public class AgenceController {

	@Autowired
    private AgenceService agenceService;

    @PostMapping("/")
    public String addUser(@RequestBody Agence agence){
        agenceService.addAgence(agence);
        return "User Added Successfully...";
    }

    @GetMapping("/")
    public List<Agence> getAllAgence(){
    	return agenceService.getAllAgences();
    }
    
    @GetMapping("/{id}")
    public Optional<Agence> getAgenceById( @PathVariable("id") UUID id){
        return agenceService.getAgenceById(id);
    }

    @PutMapping("/{id}")
    public String updateAgence( @PathVariable("id") UUID id,@RequestBody Agence agence) {
    	if(agenceService.updateAgence(id, agence)!=0)
    		return "User Updated Successfully...";
    	else
    		return "User Not Updated";
    }
    
    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable("id") UUID id){
        agenceService.deleteAgence(id);
    }

}