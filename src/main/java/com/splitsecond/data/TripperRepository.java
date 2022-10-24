package com.splitsecond.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "tripper", path = "tripper")
public interface TripperRepository extends CrudRepository<Tripper, TripperId> {
    List<Tripper> findByTripId(UUID tripId);
}
