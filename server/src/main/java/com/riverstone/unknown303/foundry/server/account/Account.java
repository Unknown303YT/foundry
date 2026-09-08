package com.riverstone.unknown303.foundry.server.account;

import com.riverstone.unknown303.foundry.server.organization.member.OrganizationMembership;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private UUID id;

    private String username;

    private String email;

    @OneToMany(
            mappedBy = "account",
            fetch = FetchType.LAZY
    )
    private List<OrganizationMembership> memberships = new ArrayList<>();

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

    public List<OrganizationMembership> getMemberships() {
        return Collections.unmodifiableList(memberships);
    }
}