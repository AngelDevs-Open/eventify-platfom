package com.eventify.platfom.SocialEvent.domain.model.commands;

import java.util.List;

public record DeleteSocialEventsCommand(List<Long> ids ) {
}
