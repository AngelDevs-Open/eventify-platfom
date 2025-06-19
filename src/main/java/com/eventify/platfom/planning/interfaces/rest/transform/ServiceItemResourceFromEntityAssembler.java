package com.eventify.platfom.planning.interfaces.rest.transform;

import com.eventify.platfom.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platfom.planning.interfaces.rest.resources.ServiceItemResource;

public class ServiceItemResourceFromEntityAssembler {
    public static ServiceItemResource toResourceFromEntity(ServiceItem entity){
        return new ServiceItemResource(entity.getServiceItemId(),entity.getDescription(),entity.getQuantity(),entity.getUnitPrice(),entity.getTotalPrice(),entity.getQuoteId());
    }
}
