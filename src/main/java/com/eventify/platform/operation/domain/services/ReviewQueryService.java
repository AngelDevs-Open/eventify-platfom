package com.eventify.platform.operation.domain.services;

import com.eventify.platform.operation.domain.model.aggreagates.Review;
import com.eventify.platform.operation.domain.model.queries.GetAllReviewsQuery;
import com.eventify.platform.operation.domain.model.queries.GetReviewByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    Optional<Review> handle(GetReviewByIdQuery query);
    List<Review> handle(GetAllReviewsQuery query);
}
