package com.riverstone.unknown303.foundry.server.organization.role;

import com.riverstone.unknown303.foundry.server.organization.Organization;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class OrganizationRole {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organization organization;

    private String name;

    private boolean owner;

    protected OrganizationRole() {}

    public OrganizationRole(UUID id, Organization organization, String name, boolean owner) {
        this.id = id;
        this.organization = organization;
        this.name = name;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }

    public boolean isOwner() {
        return owner;
    }
}
