package com.riverstone.unknown303.foundry.server.api;

public class FoundryException extends RuntimeException {
    private final ErrorCode errorCode;

    protected FoundryException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
