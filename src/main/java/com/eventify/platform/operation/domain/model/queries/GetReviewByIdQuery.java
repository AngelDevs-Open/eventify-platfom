package com.eventify.platform.operation.domain.model.queries;

public record GetReviewByIdQuery(Long reviewId) {
    public GetReviewByIdQuery {
        if (reviewId == null || reviewId <= 0) {
            throw new IllegalArgumentException("Review ID must be a positive number.");
        }
    }
}
