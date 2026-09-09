package com.riverstone.unknown303.foundry.server.account;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account create(String username, String email) {
        UUID id = UUID.randomUUID();

        Account account = new Account(id, username, email);

        return repository.save(account);
    }

    public Account findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public void delete(UUID id) {
        if (!repository.existsById(id))
            throw new AccountNotFoundException(id);

        repository.deleteById(id);
    }

    public AccountResponse toResponse(Account account) {
        return new AccountResponse(account.getId(), account.getUsername(), account.getEmail());
    }
}
