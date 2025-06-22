package com.eventify.platfom.planning.domain.model.queries;

import com.eventify.platfom.planning.domain.model.valueobjects.QuoteId;

public record GetAllServiceItemsByQuoteIdQuery(QuoteId quoteId) {
}
