package com.eventify.platform.operation.interfaces.rest.resources;

public record CreateReviewResource(String content, String fullName, String socialEventName, String socialEventDate, Integer rating, String socialEventId) {
    public CreateReviewResource {
        if (content == null || content.isBlank()) throw new IllegalArgumentException("Content cannot be null or empty.");

        if (rating == null) throw new IllegalArgumentException("Rating cannot be null or empty.");

        if (fullName == null || fullName.isBlank()) throw new IllegalArgumentException("Full name cannot be null or empty.");

        if (socialEventName == null || socialEventName.isBlank()) throw new IllegalArgumentException("Social event name cannot be null or empty.");

        if (socialEventDate == null || socialEventDate.isBlank()) throw new IllegalArgumentException("Social event date cannot be null or empty.");

    }
}
