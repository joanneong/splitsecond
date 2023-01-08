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
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "expenditure")
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "creation_date")
    private OffsetDateTime creationDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "paid_by", referencedColumnName = "id", nullable = false)
    private Tripper paidBy;

    @ManyToOne
    @JoinColumn(name = "owed_by", referencedColumnName = "id", nullable = false)
    private Tripper owedBy;

    @Column(name = "amount")
    private long amount;

    @Column(name = "comment")
    private String comment;

    protected Expenditure() { }

    public Expenditure(OffsetDateTime creationDate, Trip trip, Tripper paidBy, Tripper owedBy, long amount, String comment) {
        this.creationDate = creationDate;
        this.trip = trip;
        this.paidBy = paidBy;
        this.owedBy = owedBy;
        this.amount = amount;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Tripper getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Tripper paidBy) {
        this.paidBy = paidBy;
    }

    public Tripper getOwedBy() {
        return owedBy;
    }

    public void setOwedBy(Tripper owedBy) {
        this.owedBy = owedBy;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("creationDate", creationDate)
                .add("tripId", trip.getId())
                .add("paidBy", paidBy.getTripperName())
                .add("owedBy", owedBy.getTripperName())
                .add("amount", amount)
                .toString();
    }
}
