package com.eventify.platform.planning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable

public enum StatusType {
    ACTIVE,
    TO_CONFIRM,
    CANCELLED,
    COMPLETED
}
