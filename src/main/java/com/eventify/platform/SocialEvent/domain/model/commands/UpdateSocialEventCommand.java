package com.eventify.platform.SocialEvent.domain.model.commands;

/**
 * Command to request updating an existing Social Event's information.
 *
 * @param id           the ID of the social event to update
 * @param title        the new title of the event
 * @param place        the new location of the event
 * @param date         the new date of the event (ISO format)
 * @param customerName the updated organizer name
 * @param status       the new status of the event
 */
public record UpdateSocialEventCommand( Long id,
                                        String title,
                                        String place,
                                        String date,
                                        String customerName,
                                        String status ) {
}
