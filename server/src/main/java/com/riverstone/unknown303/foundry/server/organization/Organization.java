package com.riverstone.unknown303.foundry.server.organization;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Organization {
    @Id
    private UUID id;

    private String name;

    protected Organization() {}

    public Organization(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
