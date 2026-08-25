package com.riverstone.unknown303.foundry.server.organization.role;

import com.riverstone.unknown303.foundry.server.api.ErrorCode;
import com.riverstone.unknown303.foundry.server.api.FoundryException;

import java.util.UUID;

public class RoleNotFoundException extends FoundryException {
    public RoleNotFoundException(UUID id) {
        super(
                ErrorCode.ROLE_NOT_FOUND,
                "Organization Role with ID " + id + " does not exist."
        );
    }
}
