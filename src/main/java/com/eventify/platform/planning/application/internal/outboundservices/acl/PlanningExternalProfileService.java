package com.eventify.platform.planning.application.internal.outboundservices.acl;

import com.eventify.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

@Service
public class PlanningExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;
    public PlanningExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public boolean verifyIfExistProfileById(Long profileId) {
        var existsProfile = profilesContextFacade.isOrganizerProfile(profileId);
        return existsProfile;
    }
}
