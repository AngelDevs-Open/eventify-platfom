package com.eventify.platform.operation.application.internal.commandservices;

import com.eventify.platform.operation.application.internal.outboundservices.acl.ExternalProfileService;
import com.eventify.platform.operation.domain.model.aggreagates.Review;
import com.eventify.platform.operation.domain.model.commands.CreateReviewCommand;
import com.eventify.platform.operation.domain.services.ReviewCommandService;
import com.eventify.platform.operation.infrastructure.persistence.jpa.repositories.ReviewRepository;

public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final ExternalProfileService externalProfileService;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository, ExternalProfileService externalProfileService){
        this.reviewRepository = reviewRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Long handle(CreateReviewCommand command) {
        var review = new Review(command);
        try{
            reviewRepository.save(review);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create review: " + e.getMessage(), e);
        }
        return review.getId();
    }
}
