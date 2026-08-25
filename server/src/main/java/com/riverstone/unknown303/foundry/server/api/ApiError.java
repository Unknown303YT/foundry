package com.riverstone.unknown303.foundry.server.api;

import java.time.Instant;

public record ApiError(
        String code,
        String message,
        Instant timestamp
) {
}