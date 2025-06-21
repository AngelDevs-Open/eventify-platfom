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
        // Fetch profile from an external service by full name
        var profileId = externalProfileService.fetchProfileByFullName(command.fullName());
        if (profileId.isEmpty()) {
            throw new IllegalArgumentException("Profile with full name '" + command.fullName() + "' not found.");
        }
        // Fetch social event from an external service by social event name and date
        // Put logic here


        var review = new Review(command, profileId.get());
        try{
            reviewRepository.save(review);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create review: " + e.getMessage(), e);
        }
        return review.getId();
    }
}
