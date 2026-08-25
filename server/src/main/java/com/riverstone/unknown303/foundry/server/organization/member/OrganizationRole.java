package com.riverstone.unknown303.foundry.server.organization.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class OrganizationRole {
    @Id
    private UUID id;

    private UUID organizationId;

    private String name;

    private boolean owner;

    protected OrganizationRole() {}

    public OrganizationRole(UUID id, UUID organizationId, String name, boolean owner) {
        this.id = id;
        this.organizationId = organizationId;
        this.name = name;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public boolean isOwner() {
        return owner;
    }
}
