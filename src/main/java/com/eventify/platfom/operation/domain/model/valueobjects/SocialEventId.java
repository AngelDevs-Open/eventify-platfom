package com.eventify.platfom.operation.domain.model.valueobjects;

public record SocialEventId(Long socialEventId) {

    public SocialEventId {
        if (socialEventId == null || socialEventId <= 0) {
            throw new IllegalArgumentException("Social Event id must be a positive number.");
        }
    }
}
