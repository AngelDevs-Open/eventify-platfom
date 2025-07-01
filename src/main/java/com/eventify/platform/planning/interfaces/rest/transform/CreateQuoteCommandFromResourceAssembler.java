package com.eventify.platform.planning.interfaces.rest.transform;

import com.eventify.platform.planning.domain.model.commands.CreateQuoteCommand;
import com.eventify.platform.planning.domain.model.valueobjects.EventType;
import com.eventify.platform.planning.domain.model.valueobjects.QuoteStatus;
import com.eventify.platform.planning.interfaces.rest.resources.CreateQuoteResource;

public class CreateQuoteCommandFromResourceAssembler {

    public static CreateQuoteCommand toCommandFromResource(CreateQuoteResource resource){
        return new CreateQuoteCommand(resource.title(), EventType.valueOf(resource.eventType()),resource.guestQuantity(),resource.location(),resource.totalPrice(), QuoteStatus.valueOf(resource.state()),resource.eventDate(),resource.organizerId(), resource.hostId());
    }
}
