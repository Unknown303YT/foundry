package com.riverstone.unknown303.foundry.server.organization.member;

import com.riverstone.unknown303.foundry.server.api.ErrorCode;
import com.riverstone.unknown303.foundry.server.api.FoundryException;

import java.util.UUID;

public class MembershipNotFoundException extends FoundryException {
    public MembershipNotFoundException(UUID id) {
        super(ErrorCode.MEMBERSHIP_NOT_FOUND, "Membership with id '" + id + "' was not found.");
    }

    public MembershipNotFoundException(UUID accountId, UUID organizationId) {
        super(ErrorCode.MEMBERSHIP_NOT_FOUND,
                "Account '" + accountId + "' is not a member of organization '" + organizationId + "'.");
    }
}
