package com.splitsecond.controller;

import java.util.UUID;

public class TripNotFoundException extends RuntimeException {
    TripNotFoundException(UUID id) {
        super("Could not find trip with id=" + id);
    }
}
