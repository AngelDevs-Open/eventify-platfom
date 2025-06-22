package com.eventify.platfom.planning.domain.services;

import com.eventify.platfom.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platfom.planning.domain.model.commands.CreateServiceItemCommand;
import com.eventify.platfom.planning.domain.model.commands.DeleteServiceItemCommand;
import com.eventify.platfom.planning.domain.model.commands.UpdateServiceItemCommand;

import java.util.Optional;

public interface ServiceItemCommandService {
    String handle(CreateServiceItemCommand command);
    Optional<ServiceItem> handle(UpdateServiceItemCommand command);
    void handle(DeleteServiceItemCommand command);
}
