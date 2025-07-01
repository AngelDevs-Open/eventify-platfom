package com.eventify.platform.operation.interfaces.rest.transform;

import com.eventify.platform.operation.domain.model.commands.CreateReviewCommand;
import com.eventify.platform.operation.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {
    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(
            resource.content(),
            resource.firstName(),
            resource.lastName(),
            resource.socialEventName(),
            resource.socialEventDate(),
            resource.rating()
        );
    }
}
