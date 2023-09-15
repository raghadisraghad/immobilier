package com.Gestion.Immobilier.Client;

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
public class ClientServiceImpl implements ClientService{
	
	@Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client){
    	return clientRepository.save(client);
    }
	
    public List<Client> getAllClients(){
    	return clientRepository.findAll();
    }

    public Optional<Client> getClientById(UUID id){
        return clientRepository.findById(id);
    }

    public int updateClient(UUID id,Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        int nbr=0;
        if(optionalClient.isPresent()){
            Client existingClient = optionalClient.get();
            if (client.getAddress() != null) {
                existingClient.setAddress(client.getAddress());
                nbr=1;
            }

            if (client.getEmail() != null && !client.getEmail().isEmpty()) {
                existingClient.setEmail(client.getEmail());
                nbr=1;
            }

            if (client.getFullName() != null && !client.getFullName().isEmpty()) {
                existingClient.setFullName(client.getFullName());
                nbr=1;
            }

            if (client.getGender() != null) {
                existingClient.setGender(client.getGender());
                nbr=1;
            }

            if (client.getTel() != 0) {
                existingClient.setTel(client.getTel());
                nbr=1;
            }

            if (client.getWhatsApp() != 0) {
                existingClient.setWhatsApp(client.getWhatsApp());
                nbr=1;
            }

            if (client.getPassword() != null) {
                existingClient.setPassword(client.getPassword());
                nbr=1;
            }

            clientRepository.save(existingClient);
        }
        return nbr;
    }

    public void deleteClient(UUID id){
    	clientRepository.deleteById(id);
    }

    public void addProjectAnnouncement(UUID id,ProjectAnnouncement annonce) {
    	Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.addProjectAnnouncement(annonce);
            clientRepository.save(client);
        }
        else
        	System.out.println("User unvalid!!");
    }
    
    public void addOtherAnnouncement(String typeAnnonce,UUID id,OtherAnnouncement annonce) {
    	Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.addOtherAnnouncement(typeAnnonce,annonce);
            clientRepository.save(client);
        }
    }
    
    public Announcements findAnnonceById(UUID ID,UUID id) {
    	Optional<Client> optionalClient = clientRepository.findById(ID);
        if (optionalClient.isPresent()) {
        	Client client = optionalClient.get();
        	return client.findAnnonceById(id);
        }
        return null;
    }
	
    public Client deleteAnnouncement(UUID ID,UUID id) {
    	Optional<Client> optionalClient = clientRepository.findById(ID);
        if (optionalClient.isPresent()) {
        	Client client = optionalClient.get();
            client.deleteAnnouncement(id);
            return clientRepository.save(client);
        }
        return null;
    }	
    
    public Client updateProjectAnnouncement(UUID ID, UUID id,ProjectAnnouncement project) {
        Optional<Client> optionalClient = clientRepository.findById(ID);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.updateProjectAnnouncement(id, project);
            return clientRepository.save(client);
        }
        return null;
    }	
    
    public Client updateOtherAnnouncement(UUID ID, UUID id,OtherAnnouncement other) {
        Optional<Client> optionalClient = clientRepository.findById(ID);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.updateOtherAnnouncement(id, other);
            return clientRepository.save(client);
        }
        return null;
    }	

    public List<Announcements> getAllAnnonces(UUID ID) {
    	Optional<Client> optionalClient = clientRepository.findById(ID);
        if (optionalClient.isPresent()) {
        	Client client = optionalClient.get();
        	return client.getAllAnnonces();
        }
        return null;
    }

    public List<Announcements> AllAnnonces() {
        List<Announcements> everything = new ArrayList<>();
        for (Client pro : clientRepository.findAll()){
            everything.addAll(pro.getAllAnnonces());
        }
        return everything;
    }

    public void saveAnnonce(UUID id,Announcements save) {
        Optional<Client> optionalPro = clientRepository.findById(id);
        Client client = optionalPro.get();
        client.saveAnnonce(save);
        clientRepository.save(client);
    }

    public void deleteAnnonce(UUID id,UUID ID) {
        Optional<Client> optionalPro = clientRepository.findById(id);
        Client client = optionalPro.get();
        client.deleteAnnonce(ID);
        clientRepository.save(client);
    }

    public List<Announcements> favoriteAnnonces(UUID id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return client.getFavorites();
        }
        return null;
    }
}
