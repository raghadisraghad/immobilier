package com.Gestion.Immobilier.Agence;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherAnnouncement;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectAnnouncement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgenceServiceImpl implements AgenceService{
	
	@Autowired
    private AgenceRepository agenceRepository;

    public Agence addAgence(Agence agence){
    	return agenceRepository.save(agence);
    }

    public List<Agence> getAllAgences(){
    	return agenceRepository.findAll();
    }

    public Optional<Agence> getAgenceById(UUID id){
        return agenceRepository.findById(id);
    }

    public int updateAgence(UUID id,Agence agence) {
        Optional<Agence> optionalAgence = agenceRepository.findById(id);
        int nbr=0;
        if(optionalAgence.isPresent()){
            Agence existingAgence = optionalAgence.get();
            if (agence.getNomAgence() != null) {
                existingAgence.setNomAgence(null);
                nbr=1;
            }

            if (agence.getAddress() != null) {
                existingAgence.setAddress(agence.getAddress());
                nbr=1;
            }

            if (agence.getEmail() != null && !agence.getEmail().isEmpty()) {
                existingAgence.setEmail(agence.getEmail());
                nbr=1;
            }

            if (agence.getFullName() != null && !agence.getFullName().isEmpty()) {
                existingAgence.setFullName(agence.getFullName());
                nbr=1;
            }

            if (agence.getGender() != null) {
                existingAgence.setGender(agence.getGender());
                nbr=1;
            }

            if (agence.getTel() != 0) {
                existingAgence.setTel(agence.getTel());
                nbr=1;
            }

            if (agence.getWhatsApp() != 0) {
                existingAgence.setWhatsApp(agence.getWhatsApp());
                nbr=1;
            }

            if (agence.getPassword() != null) {
                existingAgence.setPassword(agence.getPassword());
                nbr=1;
            }

            agenceRepository.save(existingAgence);
        }
        return nbr;
    }

    public void deleteAgence(UUID id){
        agenceRepository.deleteById(id);
    }

    public void addProjectAnnouncement(UUID id,ProjectAnnouncement annonce) {
    	Optional<Agence> optionalAgence = agenceRepository.findById(id);
        if (optionalAgence.isPresent()) {
        	Agence agence = optionalAgence.get();
        	agence.addProjectAnnouncement(annonce);
            agenceRepository.save(agence);
        }
        else
        	System.out.println("User unvalid!!");
    }
    
    public void addOtherAnnouncement(String typeAnnonce,UUID id,OtherAnnouncement annonce) {
    	Optional<Agence> optionalAgence = agenceRepository.findById(id);
        if (optionalAgence.isPresent()) {
        	Agence agence = optionalAgence.get();
        	agence.addOtherAnnouncement(typeAnnonce,annonce);
            agenceRepository.save(agence);
        }
    }
    
    public Announcements findAnnonceById(UUID ID, UUID id) {
        Optional<Agence> optionalAgence = agenceRepository.findById(ID);
        if (optionalAgence.isPresent()) {
            Agence agence = optionalAgence.get();
            return agence.findAnnonceById(id);
        }
        return null;
    }
	
    public Agence deleteAnnouncement(UUID ID,UUID id) {
    	Optional<Agence> optionalAgence = agenceRepository.findById(ID);
        if (optionalAgence.isPresent()) {
        	Agence agence = optionalAgence.get();
        	agence.deleteAnnouncement(id);
        	return agenceRepository.save(agence);
        }
        return null;
    }

    public Agence updateProjectAnnouncement(UUID ID, UUID id, ProjectAnnouncement project) {
        Optional<Agence> optionalClient = agenceRepository.findById(ID);
        if (optionalClient.isPresent()) {
            Agence agence = optionalClient.get();
            agence.updateProjectAnnouncement(id, project);
            return agenceRepository.save(agence);
        }
        return null;
    }

    public Agence updateOtherAnnouncement(UUID ID, UUID id,OtherAnnouncement other) {
        Optional<Agence> optionalClient = agenceRepository.findById(ID);
        if (optionalClient.isPresent()) {
            Agence agence = optionalClient.get();
            agence.updateOtherAnnouncement(id, other);
            return agenceRepository.save(agence);
        }
        return null;
    }

    public List<Announcements> getAllAnnonces(UUID ID) {
    	Optional<Agence> optionalAgence = agenceRepository.findById(ID);
        if (optionalAgence.isPresent()) {
        	Agence agence = optionalAgence.get();
        	return agence.getAllAnnonces();
        }
        return null;
    }

    public List<Announcements> AllAnnonces() {
        List<Announcements> everything = new ArrayList<>();
        for (Agence pro : agenceRepository.findAll()){
            everything.addAll(pro.getAllAnnonces());
        }
        return everything;
    }

    public void saveAnnonce(UUID id,Announcements save) {
        Optional<Agence> optionalPro = agenceRepository.findById(id);
        Agence agence = optionalPro.get();
        agence.saveAnnonce(save);
        agenceRepository.save(agence);
    }

    public void deleteAnnonce(UUID id,UUID ID) {
        Optional<Agence> optionalPro = agenceRepository.findById(id);
        Agence agence = optionalPro.get();
        agence.deleteAnnonce(ID);
        agenceRepository.save(agence);
    }

    public List<Announcements> favoriteAnnonces(UUID id) {
        Optional<Agence> optionalAgence = agenceRepository.findById(id);
        if (optionalAgence.isPresent()) {
            Agence agence = optionalAgence.get();
            return agence.getFavorites();
        }
        return null;
    }
}
