package com.riverstone.unknown303.foundry.server.api;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    ACCOUNT_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Account does not exist."
    ),
    ORGANIZATION_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Organization does not exist."
    ),
    ROLE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "Organization role does not exist."
    );

    private final HttpStatus status;
    private final String defaultMessage;

    ErrorCode(HttpStatus status, String defaultMessage) {
        this.status = status;
        this.defaultMessage = defaultMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
