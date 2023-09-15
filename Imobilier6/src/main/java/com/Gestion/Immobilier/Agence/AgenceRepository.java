package com.Gestion.Immobilier.Agence;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends MongoRepository<Agence, UUID> {

}
