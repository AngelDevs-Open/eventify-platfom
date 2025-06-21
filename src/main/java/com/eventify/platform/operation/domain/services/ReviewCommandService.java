package com.eventify.platform.operation.domain.services;

import com.eventify.platform.operation.domain.model.commands.CreateReviewCommand;

public interface ReviewCommandService {
    Long handle(CreateReviewCommand command);
}
