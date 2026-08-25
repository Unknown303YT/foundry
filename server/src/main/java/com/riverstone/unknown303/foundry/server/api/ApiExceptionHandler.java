package com.riverstone.unknown303.foundry.server.api;

import com.riverstone.unknown303.foundry.server.account.AccountNotFoundException;
import com.riverstone.unknown303.foundry.server.organization.OrganizationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(FoundryException.class)
    public ResponseEntity<ApiError> handleFoundryException(FoundryException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        ApiError error = new ApiError(
                errorCode.name(),
                exception.getMessage(),
                Instant.now()
        );

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(error);
    }
}
