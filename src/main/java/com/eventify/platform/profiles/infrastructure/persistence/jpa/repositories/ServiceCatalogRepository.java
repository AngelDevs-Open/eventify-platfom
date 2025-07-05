package com.eventify.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.eventify.platform.profiles.domain.model.aggregates.ServiceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for service catalog aggregate.
 */
@Repository
public interface ServiceCatalogRepository extends JpaRepository<ServiceCatalog, Long> {

    List<ServiceCatalog> findByProfile_Id(Long profileId);
}