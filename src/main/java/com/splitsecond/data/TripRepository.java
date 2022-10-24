package com.splitsecond.data;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TripRepository extends CrudRepository<Trip, UUID> { }
