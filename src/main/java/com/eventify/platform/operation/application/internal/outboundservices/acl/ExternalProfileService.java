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

    public Optional<String> fetchFullNameByProfileId(Long profileId) {
        var fullName = profilesContextFacade.fetchFullNameByProfileId(profileId);
        return fullName == null ? Optional.empty() : Optional.of(fullName);
    }


}
