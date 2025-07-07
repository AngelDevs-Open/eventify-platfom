package com.eventify.platform.planning.interfaces.rest.transform;

import com.eventify.platform.planning.domain.model.aggregates.Quote;
import com.eventify.platform.planning.interfaces.rest.resources.QuoteResource;

public class QuoteResourceFromEntityAssembler {

    public static QuoteResource toResourceFromEntity(Quote entity){
        return new QuoteResource(entity.getQuoteId(), entity.getTitle(), entity.getEventType().toString(),entity.getGuestQuantity(),entity.getLocation(),entity.getTotalPrice(),entity.getState().toString(),entity.getEventDate(),entity.getOrganizerId(),entity.getHostId());
    }
}
