package com.eventify.platform.operation.domain.model.queries;

import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;

public record ExistByProfileIdQuery(ProfileId profileId) {
    public ExistByProfileIdQuery {
        if (profileId == null || profileId.profileId() == null) {
            throw new IllegalArgumentException("Profile ID cannot be null.");
        }
    }
}
