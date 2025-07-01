package com.eventify.platform.planning.domain.services;

import com.eventify.platform.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platform.planning.domain.model.commands.CreateServiceItemCommand;
import com.eventify.platform.planning.domain.model.commands.DeleteServiceItemCommand;
import com.eventify.platform.planning.domain.model.commands.UpdateServiceItemCommand;

import java.util.Optional;

public interface ServiceItemCommandService {
    String handle(CreateServiceItemCommand command);
    Optional<ServiceItem> handle(UpdateServiceItemCommand command);
    void handle(DeleteServiceItemCommand command);
}
