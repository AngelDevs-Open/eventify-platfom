package com.eventify.platform.operation.domain.model.commands;

import java.util.Date;

public record UpdateReviewCommand(Long ReviewId, String content, String fullName, Integer rating, Date socialEventDate, Long profileId) {
    public UpdateReviewCommand {
        if (ReviewId == null || ReviewId <= 0) {
            throw new IllegalArgumentException("Review ID must be a positive number.");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty.");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
    }
}
