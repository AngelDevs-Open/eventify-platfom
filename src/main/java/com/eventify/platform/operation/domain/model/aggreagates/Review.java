package com.eventify.platform.operation.domain.model.aggreagates;

import com.eventify.platform.operation.domain.model.valueobjects.Rating;
import com.eventify.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {

    private String content;
    private Rating rating;


}
