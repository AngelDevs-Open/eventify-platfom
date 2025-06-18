package com.eventify.platfom.planning.domain.services;

import com.eventify.platfom.planning.domain.model.aggregates.Quote;
import com.eventify.platfom.planning.domain.model.queries.GetAllQuotesByHostIdQuery;
import com.eventify.platfom.planning.domain.model.queries.GetAllQuotesByOrganizerIdQuery;
import com.eventify.platfom.planning.domain.model.queries.GetQuoteByQuoteIdQuery;

import java.util.List;
import java.util.Optional;

public interface QuoteQueryService {

    List<Quote> handle(GetAllQuotesByOrganizerIdQuery query);

    List<Quote> handle(GetAllQuotesByHostIdQuery query);

    Optional<Quote> handle(GetQuoteByQuoteIdQuery query);
}
