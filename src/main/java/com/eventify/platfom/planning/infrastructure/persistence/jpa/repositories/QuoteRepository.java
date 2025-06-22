package com.eventify.platfom.planning.infrastructure.persistence.jpa.repositories;
import com.eventify.platfom.planning.domain.model.aggregates.Quote;
import com.eventify.platfom.planning.domain.model.valueobjects.HostId;
import com.eventify.platfom.planning.domain.model.valueobjects.OrganizerId;
import com.eventify.platfom.planning.domain.model.valueobjects.QuoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  QuoteRepository extends JpaRepository<Quote, QuoteId> {
    Optional<Quote> findByQuoteId(QuoteId quoteId);
    List<Quote> findAllByOrganizerId(OrganizerId organizerId);
    List<Quote> findAllByHostId(HostId hostId);
    boolean existsByTitle(String title);

    boolean existsByQuoteId(QuoteId quoteId);
    //Command to avoid that Organizer Create or Update quotes with same title
    boolean existsByTitleAndOrganizerIdAndQuoteIdIsNot(String title, OrganizerId organizerId, QuoteId quoteId);
}

