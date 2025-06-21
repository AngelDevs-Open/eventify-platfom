package com.eventify.platform.profiles.application.internal.queryservices;

import com.eventify.platform.profiles.domain.model.aggregates.Profile;
import com.eventify.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.eventify.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.eventify.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.eventify.platform.profiles.domain.services.ProfileQueryService;
import com.eventify.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProfileQueryServiceImpl
 *
 * @summary
 * Implementation of ProfileQueryService.
 * Handles all queries related to Profile aggregate.
 *
 * @since 1.0
 */
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /**
     * Handle GetAllProfilesQuery
     *
     * @param query GetAllProfilesQuery
     * @return List of all profiles
     */
    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }

    /**
     * Handle GetProfileByIdQuery
     *
     * @param query GetProfileByIdQuery containing the profile ID
     * @return Optional containing the profile if found
     */
    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }

    /**
     * Handle GetProfileByEmailQuery
     *
     * @param query GetProfileByEmailQuery containing the email address
     * @return Optional containing the profile if found
     */
    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail_Address(query.emailAddress());
    }
}