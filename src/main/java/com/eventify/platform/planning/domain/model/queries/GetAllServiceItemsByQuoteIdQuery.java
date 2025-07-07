package com.eventify.platform.planning.domain.model.queries;

import com.eventify.platform.planning.domain.model.valueobjects.QuoteId;

public record GetAllServiceItemsByQuoteIdQuery(QuoteId quoteId) {
}
