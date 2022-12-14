package com.splitsecond.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TripperRepository extends CrudRepository<Tripper, UUID> {
    List<Tripper> findByTripId(UUID tripId);
}
