package com.eventify.platform.SocialEvent.domain.model.valueobjects;


public record SocialEventTitle(String title) {


    /**
     * Constructor for SocialEventTitle.
     *
     * @param title the title of the social event
     * @throws IllegalArgumentException if the socialEventTitle is null or empty
     */
    public SocialEventTitle {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Social Event Title cannot be null or empty");
        }
    }



}
