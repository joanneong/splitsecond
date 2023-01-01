package com.splitsecond.dto;

import java.util.UUID;

public class TripperDTO {
    private UUID tripId;

    private String tripperName;

    public TripperDTO(UUID tripId, String tripperName) {
        this.tripId = tripId;
        this.tripperName = tripperName;
    }

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public String getTripperName() {
        return tripperName;
    }

    public void setTripperName(String tripperName) {
        this.tripperName = tripperName;
    }
}
