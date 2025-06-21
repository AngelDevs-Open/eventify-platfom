package com.eventify.platform.operation.infrastructure.persistence.jpa.repositories;

import com.eventify.platform.operation.domain.model.aggreagates.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
