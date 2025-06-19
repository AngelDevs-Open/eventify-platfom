package com.eventify.platform.profiles.interfaces.rest;

import com.eventify.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.eventify.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.eventify.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.eventify.platform.profiles.domain.services.ProfileCommandService;
import com.eventify.platform.profiles.domain.services.ProfileQueryService;
import com.eventify.platform.profiles.interfaces.rest.resources.CreateProfileResource;
import com.eventify.platform.profiles.interfaces.rest.resources.ProfileResource;
import com.eventify.platform.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.eventify.platform.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProfilesController
 *
 * @summary
 * REST controller for Profile aggregate.
 * Provides endpoints for profile management operations.
 *
 * @since 1.0
 */
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfilesController {

    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    /**
     * Create a new profile
     *
     * @param createProfileResource CreateProfileResource with profile data
     * @return ProfileResource if successful, error message otherwise
     */
    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileResource createProfileResource) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(createProfileResource);
        var profileId = profileCommandService.handle(createProfileCommand);
        if (profileId.isEmpty()) return ResponseEntity.badRequest().build();
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId.get());
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    /**
     * Get profile by ID
     *
     * @param profileId Profile ID
     * @return ProfileResource if found, 404 otherwise
     */
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    /**
     * Get profile by email
     *
     * @param email Email address
     * @return ProfileResource if found, 404 otherwise
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<ProfileResource> getProfileByEmail(@PathVariable String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(email);
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    /**
     * Get all profiles
     *
     * @return List of ProfileResource
     */
    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream()
                .map(ProfileResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(profileResources);
    }
}