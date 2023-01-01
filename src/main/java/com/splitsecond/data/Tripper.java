package com.splitsecond.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tripper")
public class Tripper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;

    @Column(name = "name", nullable = false)
    private String tripperName;

    protected Tripper() { }

    public Tripper(Trip trip, String name) {
        this.trip = trip;
        this.tripperName = name;
    }

    public UUID getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getTripperName() {
        return tripperName;
    }

    public void setTripperName(String tripperName) {
        this.tripperName = tripperName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tripId", trip.getId())
                .add("name", tripperName)
                .toString();
    }
}
