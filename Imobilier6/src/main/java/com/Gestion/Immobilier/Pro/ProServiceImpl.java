package com.Gestion.Immobilier.Pro;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherAnnouncement;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectAnnouncement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProServiceImpl implements ProService{
	
	@Autowired
    private ProRepository proRepository;

    public Pro addPro(Pro pro){
    	return proRepository.save(pro);
    }

    public List<Pro> getAllPros(){
        return proRepository.findAll();
    }

    public Optional<Pro> getProById(@PathVariable("id") UUID id){
        return proRepository.findById(id);
    }

    public int updatePro(UUID id, Pro pro) {
        Optional<Pro> optionalUser = proRepository.findById(id);
        int nbr=0;
        if(optionalUser.isPresent()){
            Pro existingUser = optionalUser.get();
            if (pro.getNomAgence() != null) {
                existingUser.setNomAgence(null);
                nbr++;
            }

            if (pro.getAddress() != null) {
                existingUser.setAddress(pro.getAddress());
                nbr++;
            }

            if (pro.getEmail() != null) {
                existingUser.setEmail(pro.getEmail());
                nbr++;
            }

            if (pro.getFullName() != null) {
                existingUser.setFullName(pro.getFullName());
                nbr++;
            }

            if (pro.getGender() != null) {
                existingUser.setGender(pro.getGender());
                nbr++;
            }

            if (pro.getTel() != 0) {
                existingUser.setTel(pro.getTel());
                nbr++;
            }

            if (pro.getWhatsApp() != 0) {
                existingUser.setWhatsApp(pro.getWhatsApp());
                nbr++;
            }

            if (pro.getPassword() != null) {
                existingUser.setPassword(pro.getPassword());
                nbr++;
            }

            proRepository.save(existingUser);
        }
         return nbr;
    }

    public void deletePro(UUID id){
        proRepository.deleteById(id);
    }


    public void addProjectAnnouncement(UUID id,ProjectAnnouncement annonce) {
    	Optional<Pro> optionalPro = proRepository.findById(id);
        if (optionalPro.isPresent()) {
        	Pro pro = optionalPro.get();
        	pro.addProjectAnnouncement(annonce);
            proRepository.save(pro);
        }
    }
    
    public void addOtherAnnouncement(String typeAnnonce,UUID id,OtherAnnouncement annonce) {
    	Optional<Pro> optionalPro = proRepository.findById(id);
        if (optionalPro.isPresent()) {
        	Pro pro = optionalPro.get();
        	pro.addOtherAnnouncement(typeAnnonce,annonce);
        	proRepository.save(pro);
        }
    }
    
    public Announcements findAnnonceById(UUID ID, UUID id) {
    	Optional<Pro> optionalPro = proRepository.findById(ID);
        if (optionalPro.isPresent()) {
        	Pro pro = optionalPro.get();
        	return pro.findAnnonceById(id);
        }
        return null;
    }
	
    public Pro deleteAnnouncement(UUID ID,UUID id) {
    	Optional<Pro> optionalPro = proRepository.findById(ID);
        if (optionalPro.isPresent()) {
        	Pro pro = optionalPro.get();
            pro.deleteAnnouncement(id);
            return proRepository.save(pro);
        }
        return null;
    }

    public Pro updateProjectAnnouncement(UUID ID, UUID id, ProjectAnnouncement project) {
        Optional<Pro> optionalClient = proRepository.findById(ID);
        if (optionalClient.isPresent()) {
            Pro pro = optionalClient.get();
            pro.updateProjectAnnouncement(id, project);
           return proRepository.save(pro);
        }
        return null;
    }

    public Pro updateOtherAnnouncement(UUID ID, UUID id,OtherAnnouncement other) {
        Optional<Pro> optionalClient = proRepository.findById(ID);
        if (optionalClient.isPresent()) {
            Pro pro = optionalClient.get();
            pro.updateOtherAnnouncement(id, other);
            return proRepository.save(pro);
        }
        return null;
    }	

    public List<Announcements> getAllAnnonces(UUID ID) {
    	Optional<Pro> optionalPro = proRepository.findById(ID);
        if (optionalPro.isPresent()) {
        	Pro pro = optionalPro.get();
        	return pro.getAllAnnonces();
        }
        return null;
    }

    public List<Announcements> AllAnnonces() {
        List<Announcements> everything = new ArrayList<>();
        for (Pro pro : proRepository.findAll()){
            everything.addAll(pro.getAllAnnonces());
        }
        return everything;
    }

    public void saveAnnonce(UUID id,Announcements save) {
        Optional<Pro> optionalPro = proRepository.findById(id);
        Pro pro = optionalPro.get();
        pro.saveAnnonce(save);
        proRepository.save(pro);
    }

    public void deleteAnnonce(UUID id,UUID ID) {
        Optional<Pro> optionalPro = proRepository.findById(id);
        Pro pro = optionalPro.get();
        pro.deleteAnnonce(ID);
        proRepository.save(pro);
    }

    public List<Announcements> favoriteAnnonces(UUID id) {
        Optional<Pro> optionalPro = proRepository.findById(id);
        if (optionalPro.isPresent()) {
            Pro pro = optionalPro.get();
            return pro.getFavorites();
        }
        return null;
    }
}
