package com.eventify.platform.operation.interfaces.rest;

import com.eventify.platform.operation.domain.model.queries.GetAllReviewsQuery;
import com.eventify.platform.operation.domain.model.queries.GetReviewByIdQuery;
import com.eventify.platform.operation.domain.services.ReviewCommandService;
import com.eventify.platform.operation.domain.services.ReviewQueryService;
import com.eventify.platform.operation.interfaces.rest.resources.CreateReviewResource;
import com.eventify.platform.operation.interfaces.rest.resources.ReviewResource;
import com.eventify.platform.operation.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import com.eventify.platform.operation.interfaces.rest.transform.ReviewResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if( reviewId == null || reviewId == 0L) return ResponseEntity.badRequest().build();
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);
        if (review.isEmpty()) return ResponseEntity.notFound().build();
        var reviewEntity = review.get();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(reviewEntity);
        return new ResponseEntity<>(reviewResource, HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    @Operation(summary = "Get review by id", description = "Get review by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review found"),
            @ApiResponse(responseCode = "404", description = "Review not found")})
    public ResponseEntity<ReviewResource> getReviewById(@PathVariable Long reviewId){
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);
        if (review.isEmpty()) return ResponseEntity.notFound().build();
        var reviewEntity = review.get();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(reviewEntity);
        return ResponseEntity.ok(reviewResource);
    }

    @GetMapping
    @Operation(summary = "Get all reviews", description = "Get all reviews")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reviews found"),
            @ApiResponse(responseCode = "404", description = "No reviews found")})
    public ResponseEntity<List<ReviewResource>> getAllReviews(){
        var reviews = reviewQueryService.handle(new GetAllReviewsQuery());
        if (reviews.isEmpty()) return ResponseEntity.notFound().build();
        var reviewResources = reviews.stream()
                .map(ReviewResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(reviewResources);
    }

}
