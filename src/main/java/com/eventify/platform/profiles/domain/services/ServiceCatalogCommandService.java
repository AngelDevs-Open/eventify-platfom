package com.eventify.platform.profiles.domain.services;

import com.eventify.platform.profiles.domain.model.commands.CreateServiceCatalogCommand;
import com.eventify.platform.profiles.domain.model.commands.UpdateServiceCatalogCommand;

import java.util.Optional;

/**
 * ServiceCatalog command service contract.
 */
public interface ServiceCatalogCommandService {

    Optional<Long> handle(CreateServiceCatalogCommand command);

    void handle(UpdateServiceCatalogCommand command);

    void deleteById(Long serviceCatalogId);
}