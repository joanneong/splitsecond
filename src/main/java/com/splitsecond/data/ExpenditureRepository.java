package com.splitsecond.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenditureRepository extends CrudRepository<Expenditure, UUID> {
    List<Expenditure> findByTripId(UUID tripId);
}
