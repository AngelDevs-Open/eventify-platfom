package com.eventify.platform.operation.application.internal.outboundservices.acl;

import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;
import com.eventify.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade){
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileByFullName(String firstName, String lastName) {
        var profileId = profilesContextFacade.fetchProfileIdByFullName(firstName, lastName);
        return profileId == 0L ? Optional.empty() : Optional.of(new ProfileId(profileId));
    }


}
