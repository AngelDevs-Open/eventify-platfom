package com.eventify.platfom.SocialEvent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.*;


public record SocialEventStatus(String valueStatus) {

    public SocialEventStatus {
        if (valueStatus == null) {
            throw new IllegalArgumentException("SocialEventStatus cannot be null ");
        }

    }

}
