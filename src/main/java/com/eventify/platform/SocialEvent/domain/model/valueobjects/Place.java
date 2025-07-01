package com.eventify.platform.SocialEvent.domain.model.valueobjects;

public record Place(String place) {

    public Place {
        if (place == null || place.isBlank()) {
            throw new IllegalArgumentException("Place cannot be null or blank");
        }
    }

}
