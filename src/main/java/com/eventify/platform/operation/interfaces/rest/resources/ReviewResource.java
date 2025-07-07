package com.eventify.platform.operation.interfaces.rest.resources;

import java.util.Date;

public record ReviewResource(Long Id, String content, String fullName, Date socialEventDate, Integer rating, Long profileId) {
}
