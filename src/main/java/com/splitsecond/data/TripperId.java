package com.splitsecond.data;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class TripperId implements Serializable {
    private UUID tripId;

    private String tripperName;

    protected TripperId() { }

    public TripperId(UUID tripId, String tripperName) {
        this.tripId = tripId;
        this.tripperName = tripperName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TripperId)) {
            return false;
        }

        TripperId other = (TripperId) o;
        return tripId.equals(other.tripId)
                && tripperName.equals(other.tripperName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, tripperName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("trip_id", tripId)
                .add("tripper_name", tripperName)
                .toString();
    }
}
