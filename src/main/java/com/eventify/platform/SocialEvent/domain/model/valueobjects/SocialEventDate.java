package com.eventify.platform.SocialEvent.domain.model.valueobjects;

import java.time.LocalDate;

public record SocialEventDate(LocalDate eventDate) {

    public SocialEventDate {
        if (eventDate == null) {
            throw new IllegalArgumentException("Event date cannot be null");
        }
        if (eventDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Event date cannot be in the past");
        }
    }

}
