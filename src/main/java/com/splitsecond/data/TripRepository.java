package com.splitsecond.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "trip", path = "trip")
public interface TripRepository extends CrudRepository<Trip, UUID> { }
