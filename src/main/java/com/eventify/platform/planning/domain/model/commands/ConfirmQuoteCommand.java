package com.eventify.platform.planning.domain.model.commands;

import com.eventify.platform.planning.domain.model.valueobjects.QuoteId;

public record ConfirmQuoteCommand(QuoteId quoteId) {
    public ConfirmQuoteCommand{
        if(quoteId == null || quoteId.quoteId().isBlank()){
            throw new IllegalArgumentException("Quote id cannot be null or blank");
        }
    }
}
