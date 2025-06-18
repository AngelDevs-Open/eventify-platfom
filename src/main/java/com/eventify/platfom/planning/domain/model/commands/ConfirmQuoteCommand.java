package com.eventify.platfom.planning.domain.model.commands;

import com.eventify.platfom.planning.domain.model.valueobjects.QuoteId;

public record ConfirmQuoteCommand(QuoteId quoteId) {
    public ConfirmQuoteCommand{
        if(quoteId == null || quoteId.quoteId().isBlank()){
            throw new IllegalArgumentException("Quote id cannot be null or blank");
        }
    }
}
