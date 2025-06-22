package com.eventify.platform.operation.interfaces.rest.resources;

public record CreateReviewResource(String content, String firstName, String lastName, String socialEventName, String socialEventDate, Integer rating, String socialEventId) {
    public CreateReviewResource {
        if (content == null || content.isBlank()) throw new IllegalArgumentException("Content cannot be null or empty.");

        if (rating == null) throw new IllegalArgumentException("Rating cannot be null or empty.");

        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Full name cannot be null or empty.");

        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or empty.");

        if (socialEventName == null || socialEventName.isBlank()) throw new IllegalArgumentException("Social event name cannot be null or empty.");

        if (socialEventDate == null || socialEventDate.isBlank()) throw new IllegalArgumentException("Social event date cannot be null or empty.");

    }
}
