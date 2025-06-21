package com.eventify.platform.operation.interfaces.rest.resources;

public record ReviewResource(Long Id, String content, String fullName, String socialEventName, String socialEventDate, Integer rating) {
}
