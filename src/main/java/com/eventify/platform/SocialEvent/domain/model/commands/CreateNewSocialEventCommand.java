package com.eventify.platform.SocialEvent.domain.model.commands;

/**
 * Command to request the creation of a Social Event.
 *
 * @param title        the title of the event
 * @param place        the location of the event
 * @param date         the date the event will take place
 * @param customerName the name of the event organizer
 * @param status       the initial status (e.g., ACTIVE, TO_CONFIRM)
 */

public record CreateNewSocialEventCommand(
    String title,
    String place,
    String date,
    String customerName,
    String status
) {
}
