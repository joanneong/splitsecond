package com.splitsecond.controller;

import com.splitsecond.controller.converter.DTOToDataObjectConverter;
import com.splitsecond.controller.exception.TripNotFoundException;
import com.splitsecond.data.Trip;
import com.splitsecond.data.TripRepository;
import com.splitsecond.dto.TripDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/trip")
class TripController {
    private final TripRepository tripRepository;
    private final DTOToDataObjectConverter dtoToDataObjectConverter;

    TripController(TripRepository tripRepository, DTOToDataObjectConverter dtoToDataObjectConverter) {
        this.tripRepository = tripRepository;
        this.dtoToDataObjectConverter = dtoToDataObjectConverter;
    }

    @GetMapping("/{id}")
    Trip getTrip(@PathVariable UUID id) {
        return tripRepository.findById(id).orElseThrow(() -> new TripNotFoundException(id));
    }

    @PostMapping
    Trip createTrip(@RequestBody TripDTO tripDTO) {
        Trip newTrip = dtoToDataObjectConverter.convertTrip(tripDTO);
        return tripRepository.save(newTrip);
    }

    @DeleteMapping("/{id}")
    void deleteTrip(@PathVariable UUID id) {
        tripRepository.deleteById(id);
    }
}
