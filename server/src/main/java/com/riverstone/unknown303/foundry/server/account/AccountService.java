package com.riverstone.unknown303.foundry.server.account;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private final Map<UUID, Account> accounts = new HashMap<>();

    public Account create(String username, String email) {
        UUID id = UUID.randomUUID();

        Account account = new Account(id, username, email);
        accounts.put(id, account);

        return account;
    }

    public Optional<Account> findById(UUID id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public List<Account> findAll() {
        return List.copyOf(accounts.values());
    }

    public boolean delete(UUID id) {
        return accounts.remove(id) != null;
    }
}
