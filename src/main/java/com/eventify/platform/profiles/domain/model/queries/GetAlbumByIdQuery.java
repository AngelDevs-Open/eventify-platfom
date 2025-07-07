package com.eventify.platform.profiles.domain.model.queries;

/**
 * Query to retrieve an album by id.
 *
 * @param albumId album identifier
 */
public record GetAlbumByIdQuery(Long albumId) {
}