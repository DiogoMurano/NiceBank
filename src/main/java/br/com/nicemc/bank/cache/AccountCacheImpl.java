package br.com.nicemc.bank.cache;

import br.com.nicemc.bank.account.Account;
import org.apache.commons.lang.Validate;

import java.util.*;

public class AccountCacheImpl implements AccountCache {

    private final Set<Account> accounts;

    public AccountCacheImpl() {
        accounts = new HashSet<>();
    }

    @Override
    public Set<Account> findAll() {
        return accounts;
    }

    @Override
    public Optional<Account> findByUUID(UUID uniqueId) {
        return accounts.stream()
                .filter(account -> account.getId().equals(uniqueId))
                .findAny();
    }

    @Override
    public Optional<Account> findByName(String name) {
        return accounts.stream()
                .filter(account -> account.getPlayerName().equals(name))
                .findAny();
    }

    @Override
    public void addAll(List<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    @Override
    public void save(Account account) {
        Validate.notNull(account, "account can't be null.");
        this.accounts.add(account);
    }

    @Override
    public void remove(Account account) {
        Validate.notNull(account, "account can't be null.");
        this.accounts.remove(account);
    }
}
