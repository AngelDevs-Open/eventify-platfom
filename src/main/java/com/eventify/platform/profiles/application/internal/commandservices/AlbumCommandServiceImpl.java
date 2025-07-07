package com.eventify.platform.profiles.application.internal.commandservices;

import com.eventify.platform.profiles.domain.model.aggregates.Album;
import com.eventify.platform.profiles.domain.model.aggregates.Profile;
import com.eventify.platform.profiles.domain.model.commands.CreateAlbumCommand;
import com.eventify.platform.profiles.domain.model.commands.UpdateAlbumCommand;
import com.eventify.platform.profiles.domain.model.valueobjects.ProfileType;
import com.eventify.platform.profiles.domain.services.AlbumCommandService;
import com.eventify.platform.profiles.infrastructure.persistence.jpa.repositories.AlbumRepository;
import com.eventify.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of album command service.
 */
@Service
public class AlbumCommandServiceImpl implements AlbumCommandService {

    private final AlbumRepository albumRepository;
    private final ProfileRepository profileRepository;

    public AlbumCommandServiceImpl(AlbumRepository albumRepository, ProfileRepository profileRepository) {
        this.albumRepository = albumRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Long> handle(CreateAlbumCommand command) {
        var profileOpt = profileRepository.findById(command.profileId());
        if (profileOpt.isEmpty()) return Optional.empty();
        Profile profile = profileOpt.get();
        if (profile.getType() != ProfileType.ORGANIZER) return Optional.empty();
        var album = new Album(profile, command.title(), command.description(), command.photos());
        albumRepository.save(album);
        return Optional.of(album.getId());
    }

    @Override
    public void handle(UpdateAlbumCommand command) {
        var albumOpt = albumRepository.findById(command.albumId());
        if (albumOpt.isEmpty()) return;
        var album = albumOpt.get();
        album.update(command.title(), command.description(), command.photos());
        albumRepository.save(album);
    }

    @Override
    public void deleteById(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}