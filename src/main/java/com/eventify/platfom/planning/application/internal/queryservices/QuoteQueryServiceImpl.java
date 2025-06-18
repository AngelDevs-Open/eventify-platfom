package com.eventify.platfom.planning.application.internal.queryservices;

import com.eventify.platfom.planning.domain.model.aggregates.Quote;
import com.eventify.platfom.planning.domain.model.queries.GetAllQuotesByHostIdQuery;
import com.eventify.platfom.planning.domain.model.queries.GetAllQuotesByOrganizerIdQuery;
import com.eventify.platfom.planning.domain.model.queries.GetQuoteByQuoteIdQuery;
import com.eventify.platfom.planning.domain.services.QuoteQueryService;
import com.eventify.platfom.planning.infrastructure.persistence.jpa.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteQueryServiceImpl implements QuoteQueryService {
    private final QuoteRepository quoteRepository;

    public QuoteQueryServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public List<Quote> handle(GetAllQuotesByOrganizerIdQuery query){
        return quoteRepository.findAllByOrganizerId(query.organizerId());
    }

    @Override
    public List<Quote> handle(GetAllQuotesByHostIdQuery query){
        return quoteRepository.findAllByHostId(query.hostId());
    }

    public Optional<Quote> handle(GetQuoteByQuoteIdQuery query){
        return quoteRepository.findByQuoteId(query.quoteId());
    }
}
