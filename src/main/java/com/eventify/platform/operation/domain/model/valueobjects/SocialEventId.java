package com.eventify.platform.operation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SocialEventId(Long socialEventId) {

    public SocialEventId {
        if (socialEventId == null || socialEventId <= 0) {
            throw new IllegalArgumentException("Social Event id must be a positive number.");
        }
    }
}
