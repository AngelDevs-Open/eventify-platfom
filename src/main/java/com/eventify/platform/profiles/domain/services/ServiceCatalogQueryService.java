package com.eventify.platform.profiles.domain.services;

import com.eventify.platform.profiles.domain.model.aggregates.ServiceCatalog;
import com.eventify.platform.profiles.domain.model.queries.GetServiceCatalogByIdQuery;
import com.eventify.platform.profiles.domain.model.queries.GetServiceCatalogsByProfileIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * ServiceCatalog query service contract.
 */
public interface ServiceCatalogQueryService {

    List<ServiceCatalog> handle(GetServiceCatalogsByProfileIdQuery query);

    Optional<ServiceCatalog> handle(GetServiceCatalogByIdQuery query);
}