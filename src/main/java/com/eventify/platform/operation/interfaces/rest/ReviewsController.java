package com.eventify.platform.operation.interfaces.rest;

import com.eventify.platform.operation.domain.services.ReviewCommandService;
import com.eventify.platform.operation.domain.services.ReviewQueryService;
import com.eventify.platform.operation.interfaces.rest.resources.CreateReviewResource;
import com.eventify.platform.operation.interfaces.rest.resources.ReviewResource;
import com.eventify.platform.operation.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="api/v1/reviews", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reviews", description = "Available Review Endpoints")
public class ReviewsController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    public ReviewsController(ReviewCommandService reviewCommandService, ReviewQueryService reviewQueryService) {
        this.reviewCommandService = reviewCommandService;
        this.reviewQueryService = reviewQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new review", description = "Crate a new review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Review created"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input"),
            @ApiResponse(responseCode = "404", description = "Review not found")})
    public ResponseEntity<ReviewResource> createReview(CreateReviewResource resource) {
        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(resource);
        var reviewId = reviewCommandService.handle(createReviewCommand);
        return null; // Ideally, you would set the URI of the created resou
    }
}
