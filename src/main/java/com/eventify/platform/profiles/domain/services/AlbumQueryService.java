package com.eventify.platform.profiles.domain.services;

import com.eventify.platform.profiles.domain.model.aggregates.Album;
import com.eventify.platform.profiles.domain.model.queries.GetAlbumByIdQuery;
import com.eventify.platform.profiles.domain.model.queries.GetAlbumsByProfileIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Album query service contract.
 */
public interface AlbumQueryService {


    /**
     * Get albums for a profile.
     *
     * @param query albums by profile id query
     * @return list of albums
     */
    List<Album> handle(GetAlbumsByProfileIdQuery query);


    /**
     * Get album by id.
     *
     * @param query album id query
     * @return optional album
     */
    Optional<Album> handle(GetAlbumByIdQuery query);
}