package com.riverstone.unknown303.foundry.server.organization;

import com.riverstone.unknown303.foundry.server.organization.member.OrganizationMembership;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Organization {
    @Id
    private UUID id;

    private String name;

    @OneToMany(
            mappedBy = "organization",
            fetch = FetchType.LAZY
    )
    private List<OrganizationMembership> memberships = new ArrayList<>();

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

    public List<OrganizationMembership> getMemberships() {
        return Collections.unmodifiableList(memberships);
    }
}
