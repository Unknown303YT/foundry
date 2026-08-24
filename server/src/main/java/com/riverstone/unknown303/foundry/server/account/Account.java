package com.riverstone.unknown303.foundry.server.account;

import java.util.UUID;

public class Account {
    private final UUID id;
    private final String username;
    private final String email;

    Account(UUID id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
