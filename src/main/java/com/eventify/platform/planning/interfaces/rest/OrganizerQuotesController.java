package com.eventify.platform.planning.interfaces.rest;

import com.eventify.platform.planning.domain.model.queries.GetAllQuotesByOrganizerIdQuery;
import com.eventify.platform.planning.domain.services.QuoteCommandService;
import com.eventify.platform.planning.domain.services.QuoteQueryService;
import com.eventify.platform.planning.interfaces.rest.resources.QuoteResource;
import com.eventify.platform.planning.interfaces.rest.transform.QuoteResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/organizers/{organizerId}/quotes",produces = APPLICATION_JSON_VALUE)
@Tag(name="Organizer")
public class OrganizerQuotesController {
    private final QuoteCommandService quoteCommandService;
    private final QuoteQueryService  quoteQueryService;

    public OrganizerQuotesController(QuoteCommandService quoteCommandService, QuoteQueryService quoteQueryService) {
        this.quoteCommandService = quoteCommandService;
        this.quoteQueryService = quoteQueryService;
    }

    @GetMapping
    @Operation(summary = "Get quotes of an organizer", description = "Get quotes created by an organizer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quotes retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Quotes not found")
    })
    public ResponseEntity<List<QuoteResource>> getQuotesForOrganizerWithOrganizerId(@PathVariable int organizerId){
        var profileId = organizerId;
        var getAllQuotesByOrganizerId = new GetAllQuotesByOrganizerIdQuery(profileId);
        var quotes = quoteQueryService.handle(getAllQuotesByOrganizerId);
        var quoteResources = quotes.stream().map(QuoteResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(quoteResources);
    }


}
