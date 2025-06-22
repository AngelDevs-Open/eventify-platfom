package com.eventify.platform.operation.interfaces.rest.transform;

import com.eventify.platform.operation.domain.model.aggreagates.Review;
import com.eventify.platform.operation.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {
    public static ReviewResource toResourceFromEntity(Review entity){
        return new ReviewResource(entity.getId(), entity.getContent(), entity.getFirstName(), entity.getLastName(), entity.getSocialEventName(), entity.getSocialEventDate(), entity.getRating());
    }
}
