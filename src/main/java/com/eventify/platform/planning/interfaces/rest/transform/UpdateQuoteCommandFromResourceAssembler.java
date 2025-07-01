package com.eventify.platform.planning.interfaces.rest.transform;

import com.eventify.platform.planning.domain.model.commands.UpdateQuoteCommand;
import com.eventify.platform.planning.domain.model.valueobjects.EventType;
import com.eventify.platform.planning.domain.model.valueobjects.QuoteId;
import com.eventify.platform.planning.interfaces.rest.resources.UpdateQuoteResource;

public class UpdateQuoteCommandFromResourceAssembler {
    public static UpdateQuoteCommand toCommandFromResource(String quoteId, UpdateQuoteResource resource) {
        return new UpdateQuoteCommand(new QuoteId(quoteId), resource.title(), EventType.valueOf(resource.eventType()),resource.guestQuantity(), resource.location(),resource.totalPrice(),resource.eventDate());
    }
}
