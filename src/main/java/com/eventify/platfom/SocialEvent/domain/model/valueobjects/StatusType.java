package com.eventify.platfom.SocialEvent.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

@Embeddable

public enum StatusType {
    ACTIVE,
    TO_CONFIRM,
    CANCELLED,
    COMPLETED
}
