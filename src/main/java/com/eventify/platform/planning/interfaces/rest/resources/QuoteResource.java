package com.eventify.platform.planning.interfaces.rest.resources;

import java.util.Date;

public record QuoteResource(String quoteId, String title, String eventType, int guestQuantity, String location, double totalPrice, String state, Date eventDate, int organizerId, int hostId) {
}
