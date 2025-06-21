package com.eventify.platform.operation.domain.model.commands;

import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;
import com.eventify.platform.operation.domain.model.valueobjects.ReviewRating;
import com.eventify.platform.operation.domain.model.valueobjects.SocialEventId;

public record CreateReviewCommand(String content, Integer rating, ProfileId profileId, SocialEventId socialEventId) {
    public CreateReviewCommand{
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty.");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        if (profileId == null || profileId.profileId() <= 0) {
            throw new IllegalArgumentException("Profile ID must be a positive number.");
        }
        if (socialEventId == null || socialEventId.socialEventId() <= 0) {
            throw new IllegalArgumentException("Social Event ID must be a positive number.");
        }
    }
}
