package com.splitsecond.data;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tripper")
@IdClass(TripperId.class)
public class Tripper {
    @Id
    @Column(name = "trip_id", columnDefinition = "uuid")
    private UUID tripId;

    @Id
    @Column(name = "name", nullable = false)
    private String tripperName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Trip trip;

    protected Tripper() { }

    public Tripper(UUID tripId, String name) {
        this.tripId = tripId;
        this.tripperName = name;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("trip_id", tripId)
                .add("name", tripperName)
                .toString();
    }
}
