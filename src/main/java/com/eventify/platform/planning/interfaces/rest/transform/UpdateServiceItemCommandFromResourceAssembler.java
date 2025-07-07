package com.eventify.platform.planning.interfaces.rest.transform;

import com.eventify.platform.planning.domain.model.commands.UpdateServiceItemCommand;
import com.eventify.platform.planning.domain.model.valueobjects.ServiceItemId;
import com.eventify.platform.planning.interfaces.rest.resources.UpdateServiceItemResource;

public class UpdateServiceItemCommandFromResourceAssembler {
    public static UpdateServiceItemCommand toCommandFromResource(String serviceItemId,UpdateServiceItemResource resource){
        return new UpdateServiceItemCommand(new ServiceItemId(serviceItemId),resource.description(),resource.quantity(),resource.unitPrice(),resource.totalPrice());
    }
}
