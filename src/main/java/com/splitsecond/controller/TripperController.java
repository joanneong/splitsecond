package com.splitsecond.controller;

import com.splitsecond.controller.converter.DTOToDataObjectConverter;
import com.splitsecond.data.Trip;
import com.splitsecond.data.TripRepository;
import com.splitsecond.data.Tripper;
import com.splitsecond.data.TripperRepository;
import com.splitsecond.dto.TripperDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tripper")
public class TripperController {
    private final TripperRepository tripperRepository;
    private final TripRepository tripRepository;

    TripperController(TripperRepository tripperRepository, TripRepository tripRepository) {
        this.tripperRepository = tripperRepository;
        this.tripRepository = tripRepository;
    }

    @GetMapping("/{tripId}")
    List<Tripper> getTrippersForTrip(@PathVariable UUID tripId) {
        tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException(tripId));
        return tripperRepository.findByTripId(tripId);
    }

    @PostMapping
    Tripper createTripperForTrip(@RequestBody TripperDTO tripperDTO) {
        Trip trip = tripRepository.findById(tripperDTO.getTripId())
                .orElseThrow(() -> new TripNotFoundException(tripperDTO.getTripId()));
        Tripper newTripper = DTOToDataObjectConverter.convertTripper(tripperDTO, trip);
        return tripperRepository.save(newTripper);
    }
}
