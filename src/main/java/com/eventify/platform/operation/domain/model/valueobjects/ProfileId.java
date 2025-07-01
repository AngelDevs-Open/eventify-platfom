package com.eventify.platform.operation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileId(Long profileId) {

    public ProfileId {
        if (profileId == null || profileId <= 0) {
            throw new IllegalArgumentException("Profile ID must be a positive number.");
        }
    }
}
