package com.eventify.platform.planning.interfaces.rest;

import com.eventify.platform.planning.domain.model.queries.GetSocialEventsByOrganizerQuery;
import com.eventify.platform.planning.domain.services.SocialEventQueryService;
import com.eventify.platform.planning.interfaces.rest.resources.SocialEventResource;
import com.eventify.platform.planning.interfaces.rest.transform.SocialEventResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing social events by customer/organizer.
 */
@RestController
@RequestMapping(value = "/api/v1/customers/{customerName}/social-events", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Customer Social Events", description = "Operations related to social events by customer/organizer")
public class CustomerSocialEventsController {

    private final SocialEventQueryService socialEventQueryService;

    public CustomerSocialEventsController(SocialEventQueryService socialEventQueryService) {
        this.socialEventQueryService = socialEventQueryService;
    }

    /**
     * Retrieves all social events for a specific customer/organizer.
     */
    @Operation(summary = "Get all social events for a specific customer/organizer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Social events retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping
    public ResponseEntity<List<SocialEventResource>> getSocialEventsByCustomer(@PathVariable String customerName) {
        var getByOrganizerQuery = new GetSocialEventsByOrganizerQuery(customerName);
        var socialEvents = socialEventQueryService.handle(getByOrganizerQuery);

        var socialEventResources = socialEvents.stream()
                .map(SocialEventResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(socialEventResources);
    }
}