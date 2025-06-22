package com.eventify.platfom.planning.domain.services;

import com.eventify.platfom.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platfom.planning.domain.model.queries.GetAllServiceItemsByQuoteIdQuery;
import com.eventify.platfom.planning.domain.model.queries.GetServiceItemByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ServiceItemQueryService {
    List<ServiceItem> handle(GetAllServiceItemsByQuoteIdQuery query);

    Optional<ServiceItem> handle(GetServiceItemByIdQuery query);
}
