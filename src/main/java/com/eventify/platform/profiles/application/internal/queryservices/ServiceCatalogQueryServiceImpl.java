package com.eventify.platform.profiles.application.internal.queryservices;

import com.eventify.platform.profiles.domain.model.aggregates.ServiceCatalog;
import com.eventify.platform.profiles.domain.model.queries.GetServiceCatalogByIdQuery;
import com.eventify.platform.profiles.domain.model.queries.GetServiceCatalogsByProfileIdQuery;
import com.eventify.platform.profiles.domain.services.ServiceCatalogQueryService;
import com.eventify.platform.profiles.infrastructure.persistence.jpa.repositories.ServiceCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of ServiceCatalog query service.
 */
@Service
public class ServiceCatalogQueryServiceImpl implements ServiceCatalogQueryService {

    private final ServiceCatalogRepository serviceCatalogRepository;

    public ServiceCatalogQueryServiceImpl(ServiceCatalogRepository serviceCatalogRepository) {
        this.serviceCatalogRepository = serviceCatalogRepository;
    }

    @Override
    public List<ServiceCatalog> handle(GetServiceCatalogsByProfileIdQuery query) {
        return serviceCatalogRepository.findByProfile_Id(query.profileId());
    }

    @Override
    public Optional<ServiceCatalog> handle(GetServiceCatalogByIdQuery query) {
        return serviceCatalogRepository.findById(query.serviceCatalogId());
    }
}