package com.eventify.platfom.planning.domain.model.commands;

import com.eventify.platfom.planning.domain.model.valueobjects.ServiceItemId;

public record DeleteServiceItemCommand(ServiceItemId serviceItemId) {
    public DeleteServiceItemCommand{
        if(serviceItemId == null || serviceItemId.serviceItemId().isBlank()){
            throw new IllegalArgumentException("Service Item Id cannot be null or empty");
        }
    }
}
