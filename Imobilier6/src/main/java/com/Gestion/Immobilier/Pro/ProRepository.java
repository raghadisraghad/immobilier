package com.Gestion.Immobilier.Pro;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProRepository extends MongoRepository<Pro, UUID> {
}