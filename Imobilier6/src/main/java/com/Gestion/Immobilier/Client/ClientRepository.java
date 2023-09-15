package com.Gestion.Immobilier.Client;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, UUID> {

}
