package com.eventify.platform.planning.domain.services;

import com.eventify.platform.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platform.planning.domain.model.queries.GetAllServiceItemsByQuoteIdQuery;
import com.eventify.platform.planning.domain.model.queries.GetServiceItemByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ServiceItemQueryService {
    List<ServiceItem> handle(GetAllServiceItemsByQuoteIdQuery query);

    Optional<ServiceItem> handle(GetServiceItemByIdQuery query);
}
