package com.eventify.platform.iam.interfaces.rest.transform;

import com.eventify.platform.iam.domain.model.commands.SignInCommand;
import com.eventify.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
