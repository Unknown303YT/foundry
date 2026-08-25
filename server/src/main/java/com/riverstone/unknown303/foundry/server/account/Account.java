package com.riverstone.unknown303.foundry.server.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Account {

    @Id
    private UUID id;

    private String username;

    private String email;

    protected Account() {
    }

    public Account(UUID id, String username, String email) {
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