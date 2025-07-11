package com.eventify.platform.planning.domain.model.queries;

import com.eventify.platform.planning.domain.model.valueobjects.QuoteId;

public record ExistsByQuoteIdQuery(QuoteId quoteId) {
    public ExistsByQuoteIdQuery{
        if(quoteId == null){
            throw new IllegalArgumentException("quoteId cannot be null");
        }
    }
}
