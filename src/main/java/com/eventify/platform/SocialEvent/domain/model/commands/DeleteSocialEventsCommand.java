package com.eventify.platform.SocialEvent.domain.model.commands;

import java.util.List;

public record DeleteSocialEventsCommand(List<Long> ids ) {
}
