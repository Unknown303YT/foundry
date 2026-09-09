package com.riverstone.unknown303.foundry.server.account;

import java.util.UUID;

public record AccountResponse(UUID id, String username, String email) {}
