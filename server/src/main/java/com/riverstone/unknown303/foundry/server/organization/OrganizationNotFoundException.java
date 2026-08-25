package com.riverstone.unknown303.foundry.server.organization;

import com.riverstone.unknown303.foundry.server.api.ErrorCode;
import com.riverstone.unknown303.foundry.server.api.FoundryException;

import java.util.UUID;

public class OrganizationNotFoundException extends FoundryException {
    public OrganizationNotFoundException(UUID id) {
        super(
                ErrorCode.ORGANIZATION_NOT_FOUND,
                "Organization with ID " + id + " does not exist."
        );
    }
}
