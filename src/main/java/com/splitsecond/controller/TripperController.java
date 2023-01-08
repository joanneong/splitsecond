package com.splitsecond.controller;

import com.splitsecond.controller.converter.DTOToDataObjectConverter;
import com.splitsecond.controller.exception.TripNotFoundException;
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
    private final DTOToDataObjectConverter dtoToDataObjectConverter;

    TripperController(TripperRepository tripperRepository, TripRepository tripRepository,
                      DTOToDataObjectConverter dtoToDataObjectConverter) {
        this.tripperRepository = tripperRepository;
        this.tripRepository = tripRepository;
        this.dtoToDataObjectConverter = dtoToDataObjectConverter;

    }

    @GetMapping("/{tripId}")
    List<Tripper> getTrippersForTrip(@PathVariable UUID tripId) {
        tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException(tripId));
        return tripperRepository.findByTripId(tripId);
    }

    @PostMapping
    Tripper createTripperForTrip(@RequestBody TripperDTO tripperDTO) {
        Tripper newTripper = dtoToDataObjectConverter.convertTripper(tripperDTO);
        return tripperRepository.save(newTripper);
    }
}
