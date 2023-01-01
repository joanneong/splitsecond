package com.splitsecond.controller.converter;

import com.splitsecond.data.Trip;
import com.splitsecond.data.Tripper;
import com.splitsecond.dto.TripperDTO;

public class DTOToDataObjectConverter {
    public static Tripper convertTripper(TripperDTO tripperDTO, Trip trip) {
        return new Tripper(trip, tripperDTO.getTripperName());
    }
}
