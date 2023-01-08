package com.splitsecond.controller.exception;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public class TripNotFoundException extends EntityNotFoundException {
    public TripNotFoundException(UUID id) {
        super("Could not find trip with id=" + id);
    }
}
