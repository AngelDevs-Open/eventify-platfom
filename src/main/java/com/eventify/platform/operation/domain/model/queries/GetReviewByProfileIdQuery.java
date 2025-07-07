package com.eventify.platform.operation.domain.model.queries;

import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;

public record GetReviewByProfileIdQuery(ProfileId profileId) {
    public GetReviewByProfileIdQuery {
        if (profileId == null || profileId.profileId() <= 0) {
            throw new IllegalArgumentException("Profile ID must be a positive number.");
        }
    }
}
