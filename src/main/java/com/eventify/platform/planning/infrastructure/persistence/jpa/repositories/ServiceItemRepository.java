package com.eventify.platform.planning.infrastructure.persistence.jpa.repositories;

import com.eventify.platform.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platform.planning.domain.model.valueobjects.QuoteId;
import com.eventify.platform.planning.domain.model.valueobjects.ServiceItemId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, ServiceItemId> {
    List<ServiceItem> findAllByQuoteId(QuoteId quoteId);
    boolean existsByServiceItemIdAndQuoteId(ServiceItemId serviceItemId, QuoteId quoteId);
    Optional<ServiceItem> findByServiceItemId(ServiceItemId serviceItemId);
}
