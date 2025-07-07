package com.eventify.platform.planning.domain.model.commands;

import com.eventify.platform.planning.domain.model.valueobjects.ServiceItemId;

public record DeleteServiceItemCommand(ServiceItemId serviceItemId) {
    public DeleteServiceItemCommand{
        if(serviceItemId == null || serviceItemId.serviceItemId().isBlank()){
            throw new IllegalArgumentException("Service Item Id cannot be null or empty");
        }
    }
}
