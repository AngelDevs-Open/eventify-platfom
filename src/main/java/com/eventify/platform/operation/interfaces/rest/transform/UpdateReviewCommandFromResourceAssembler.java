package com.eventify.platform.operation.interfaces.rest.transform;

import com.eventify.platform.operation.domain.model.commands.UpdateReviewCommand;
import com.eventify.platform.operation.interfaces.rest.resources.UpdateReviewResource;

import java.util.Date;

public class UpdateReviewCommandFromResourceAssembler {
    public static UpdateReviewCommand toCommandFromResource(Long reviewId, UpdateReviewResource resource) {
        return new UpdateReviewCommand(
                reviewId,
                resource.content(),
                resource.fullName(),
                resource.rating(),
                resource.socialEventDate(),
                resource.profileId());
    };
}
