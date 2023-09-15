package com.Gestion.Immobilier.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/client")
@RestController
public class ClientController {

	@Autowired
    private ClientService clientService;

    @PostMapping("/")
    public String addUser(@RequestBody Client client){
        clientService.addClient(client);
        return "User Added Successfully...";
    }

    @GetMapping("/")
    public List<Client> getAllClients(){
    	return clientService.getAllClients();
    }
    
    @GetMapping("/{id}")
    public Optional<Client> getClientById( @PathVariable("id") UUID id){
        return clientService.getClientById(id);
    }
    
    @PutMapping("/{id}")
    public String updateClient( @PathVariable("id") UUID id,@RequestBody Client client) {
    	if(clientService.updateClient(id, client)!=0)
    		return "User Updated Successfully...";
    	else
    		return "User Not Updated";
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") UUID id){
        clientService.deleteClient(id);
    }

}