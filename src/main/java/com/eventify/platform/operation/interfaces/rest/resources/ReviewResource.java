package com.eventify.platform.operation.interfaces.rest.resources;

public record ReviewResource(Long Id, String content, String firstName, String lastName, String socialEventName, String socialEventDate, Integer rating) {
}
