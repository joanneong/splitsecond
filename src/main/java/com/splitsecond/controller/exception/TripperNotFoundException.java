package com.splitsecond.controller.exception;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public class TripperNotFoundException extends EntityNotFoundException {
    public TripperNotFoundException(UUID id) {
        super("Could not find tripper with id=" + id);
    }
}
