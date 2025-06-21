package com.eventify.platform.profiles.interfaces.rest.transform;

import com.eventify.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.eventify.platform.profiles.interfaces.rest.resources.CreateProfileResource;

/**
 * CreateProfileCommandFromResourceAssembler
 *
 * @summary
 * Assembler to convert CreateProfileResource to CreateProfileCommand.
 * Transforms REST resource into domain command.
 *
 * @since 1.0
 */
public class CreateProfileCommandFromResourceAssembler {

    /**
     * Convert CreateProfileResource to CreateProfileCommand
     *
     * @param resource CreateProfileResource to convert
     * @return CreateProfileCommand with the resource data
     */
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street(),
                resource.number(),
                resource.city(),
                resource.postalCode(),
                resource.country()
        );
    }
}