package com.riverstone.unknown303.foundry.server.account;

import com.riverstone.unknown303.foundry.server.api.ErrorCode;
import com.riverstone.unknown303.foundry.server.api.FoundryException;

import java.util.UUID;

public class AccountNotFoundException extends FoundryException {
    public AccountNotFoundException(UUID id) {
        super(
                ErrorCode.ACCOUNT_NOT_FOUND,
                "Account with ID " + id + " does not exist."
        );
    }
}
