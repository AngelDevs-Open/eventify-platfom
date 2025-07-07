package com.eventify.platform.operation.infrastructure.persistence.jpa.repositories;

import com.eventify.platform.operation.domain.model.aggreagates.Review;
import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByProfileId(ProfileId profileId);
    boolean existsByProfileId(ProfileId profileId);
}
