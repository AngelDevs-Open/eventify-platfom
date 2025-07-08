package com.eventify.platform.planning.domain.model.valueobjects;


public record SocialEventStatus(String valueStatus) {

    public SocialEventStatus {
        if (valueStatus == null) {
            throw new IllegalArgumentException("SocialEventStatus cannot be null ");
        }

    }

}
