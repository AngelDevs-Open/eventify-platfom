package com.eventify.platform.planning.application.internal.queryservices;

import com.eventify.platform.planning.domain.model.aggregates.ServiceItem;
import com.eventify.platform.planning.domain.model.queries.GetAllServiceItemsByQuoteIdQuery;
import com.eventify.platform.planning.domain.model.queries.GetServiceItemByIdQuery;
import com.eventify.platform.planning.domain.services.ServiceItemQueryService;
import com.eventify.platform.planning.infrastructure.persistence.jpa.repositories.ServiceItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceItemQueryServiceImpl implements ServiceItemQueryService {
    private final ServiceItemRepository serviceItemRepository;

    public ServiceItemQueryServiceImpl(ServiceItemRepository serviceItemRepository) {
        this.serviceItemRepository = serviceItemRepository;
    }

    @Override
    public List<ServiceItem> handle(GetAllServiceItemsByQuoteIdQuery query){
        return serviceItemRepository.findAllByQuoteId(query.quoteId());
    }

    @Override
    public Optional<ServiceItem> handle(GetServiceItemByIdQuery query){
        return serviceItemRepository.findByServiceItemId(query.serviceItemId());
    }
}
