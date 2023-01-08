package com.splitsecond.controller.converter;

import com.splitsecond.controller.exception.TripNotFoundException;
import com.splitsecond.controller.exception.TripperNotFoundException;
import com.splitsecond.data.Expenditure;
import com.splitsecond.data.ExpenditureRepository;
import com.splitsecond.data.Trip;
import com.splitsecond.data.TripRepository;
import com.splitsecond.data.Tripper;
import com.splitsecond.data.TripperRepository;
import com.splitsecond.dto.ExpenditureDTO;
import com.splitsecond.dto.TripDTO;
import com.splitsecond.dto.TripperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOToDataObjectConverter {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripperRepository tripperRepository;

    @Autowired
    private ExpenditureRepository expenditureRepository;

    public DTOToDataObjectConverter(TripRepository tripRepository, TripperRepository tripperRepository,
                                    ExpenditureRepository expenditureRepository) {
        this.tripRepository = tripRepository;
        this.tripperRepository = tripperRepository;
        this.expenditureRepository = expenditureRepository;
    }

    public Trip convertTrip(TripDTO tripDTO) {
        return new Trip(tripDTO.getName(), tripDTO.getStartDate(), tripDTO.getEndDate());
    }

    public Tripper convertTripper(TripperDTO tripperDTO) {
        Trip trip = tripRepository.findById(tripperDTO.getTripId())
                .orElseThrow(() -> new TripNotFoundException(tripperDTO.getTripId()));
        return new Tripper(trip, tripperDTO.getTripperName());
    }

    public Expenditure convertExpenditure(ExpenditureDTO expenditureDTO) {
       Trip trip = tripRepository.findById(expenditureDTO.getTripId())
                .orElseThrow(() -> new TripNotFoundException(expenditureDTO.getTripId()));
       Tripper paidByTripper = tripperRepository.findById(expenditureDTO.getPaidByTripper())
               .orElseThrow(() -> new TripperNotFoundException(expenditureDTO.getPaidByTripper()));
       Tripper owedByTripper = tripperRepository.findById(expenditureDTO.getOwedByTripper())
               .orElseThrow(() -> new TripperNotFoundException(expenditureDTO.getOwedByTripper()));
        return new Expenditure(expenditureDTO.getCreationDate(), trip, paidByTripper, owedByTripper,
                expenditureDTO.getAmount(), expenditureDTO.getComment());
    }
}
