package com.splitsecond.controller;

import com.splitsecond.data.Trip;
import com.splitsecond.data.TripRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/trips")
class TripController {
    private final TripRepository tripRepository;

    TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping("/{id}")
    Trip getTrip(@PathVariable UUID id) {
        return tripRepository.findById(id).orElseThrow(() -> new TripNotFoundException(id));
    }
}
