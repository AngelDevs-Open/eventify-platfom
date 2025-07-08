package com.eventify.platform.planning.interfaces.rest.transform;

import com.eventify.platform.planning.domain.model.commands.UpdateSocialEventCommand;
import com.eventify.platform.planning.interfaces.rest.resources.UpdateSocialEventResource;

public class UpdateSocialEventCommandFromResourceAssembler {
    /**
     * Converts an UpdateSocialEventResource to an UpdateSocialEventCommand.
     *
     * @param resource the resource to convert
     * @param socialEventId the ID of the social event to update
     * @return the corresponding command
     */
    public static UpdateSocialEventCommand toCommandFromResource(UpdateSocialEventResource resource, Long socialEventId) {
        return new UpdateSocialEventCommand(
                socialEventId,
                resource.title(),
                resource.date(),
                resource.customerName(),
                resource.place(),
                resource.status()
        );
    }
}
