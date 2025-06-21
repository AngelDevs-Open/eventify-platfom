package com.eventify.platform.operation.domain.model.commands;

import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;
import com.eventify.platform.operation.domain.model.valueobjects.ReviewRating;
import com.eventify.platform.operation.domain.model.valueobjects.SocialEventId;

public record CreateReviewCommand(String content, String fullName, String socialEventName, String socialEventDate, Integer rating, SocialEventId socialEventId) {
    public CreateReviewCommand{
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty.");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be null or empty.");
        }
        if (socialEventName == null || socialEventName.isBlank()) {
            throw new IllegalArgumentException("Social event name cannot be null or empty.");
        }
        if (socialEventDate == null || socialEventDate.isBlank()) {
            throw new IllegalArgumentException("Social event date cannot be null or empty.");
        }
    }
}
