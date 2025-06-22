package com.eventify.platfom.planning.interfaces.rest.transform;

import com.eventify.platfom.planning.domain.model.commands.CreateQuoteCommand;
import com.eventify.platfom.planning.domain.model.valueobjects.EventType;
import com.eventify.platfom.planning.domain.model.valueobjects.HostId;
import com.eventify.platfom.planning.domain.model.valueobjects.OrganizerId;
import com.eventify.platfom.planning.domain.model.valueobjects.QuoteStatus;
import com.eventify.platfom.planning.interfaces.rest.resources.CreateQuoteResource;

public class CreateQuoteCommandFromResourceAssembler {

    public static CreateQuoteCommand toCommandFromResource(CreateQuoteResource resource){
        return new CreateQuoteCommand(resource.title(), EventType.valueOf(resource.eventType()),resource.guestQuantity(),resource.location(),resource.totalPrice(), QuoteStatus.valueOf(resource.state()),resource.eventDate(),new OrganizerId(resource.organizerId()), new HostId(resource.hostId()));
    }
}
