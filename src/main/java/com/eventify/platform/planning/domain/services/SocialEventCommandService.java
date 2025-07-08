package com.eventify.platform.planning.domain.services;

import com.eventify.platform.planning.domain.model.aggregates.SocialEvent;
import com.eventify.platform.planning.domain.model.commands.CreateNewSocialEventCommand;
import com.eventify.platform.planning.domain.model.commands.DeleteSocialEventCommand;
import com.eventify.platform.planning.domain.model.commands.DeleteSocialEventsCommand;
import com.eventify.platform.planning.domain.model.commands.UpdateSocialEventCommand;

import java.util.Optional;

/**
 * Service interface for handling commands related to social events.
 * This service provides methods to create, update, and delete social events.
 */


public interface SocialEventCommandService {

    /**
     * Creates a new social event.
     *
     * @param command the command containing event details
     * @return the created social event
     */
    Optional<SocialEvent> handle(CreateNewSocialEventCommand command);

    /**
     * Updates an existing social event.
     *
     * @param command the command containing updated event details
     * @return the updated social event
     */
    Optional<SocialEvent> handle(UpdateSocialEventCommand command);

    /**
     * Deletes a social event.
     *
     * @param command the command containing the event ID to delete
     */
    void handle(DeleteSocialEventCommand command);

    /**
     * Deletes multiple social events.
     *
     * @param command the command containing the list of event IDs to delete
     */
    void handle(DeleteSocialEventsCommand command);

}
