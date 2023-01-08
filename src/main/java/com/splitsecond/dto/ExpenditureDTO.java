package com.splitsecond.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class ExpenditureDTO {
    private OffsetDateTime creationDate;
    private UUID tripId;

    private UUID paidByTripper;

    private UUID owedByTripper;

    private long amount;

    private String comment;

    public ExpenditureDTO(OffsetDateTime creationDate, UUID tripId, UUID paidByTripper, UUID owedByTripper, long amount, String comment) {
        this.creationDate = creationDate;
        this.tripId = tripId;
        this.paidByTripper = paidByTripper;
        this.owedByTripper = owedByTripper;
        this.amount = amount;
        this.comment = comment;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public UUID getPaidByTripper() {
        return paidByTripper;
    }

    public void setPaidByTripper(UUID paidByTripper) {
        this.paidByTripper = paidByTripper;
    }

    public UUID getOwedByTripper() {
        return owedByTripper;
    }

    public void setOwedByTripper(UUID owedByTripper) {
        this.owedByTripper = owedByTripper;
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
}
