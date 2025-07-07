package com.eventify.platform.operation.interfaces.rest.resources;

import java.util.Date;

public record UpdateReviewResource(String content, String fullName, Date socialEventDate, Integer rating, Long profileId) {

    public UpdateReviewResource {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be null or blank");
        }
        if (socialEventDate == null) {
            throw new IllegalArgumentException("Social event date cannot be null");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
