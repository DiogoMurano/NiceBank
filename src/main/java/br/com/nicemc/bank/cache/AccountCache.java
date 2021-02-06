package br.com.nicemc.bank.cache;

import br.com.nicemc.bank.account.Account;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AccountCache {

    Set<Account> findAll();

    Optional<Account> findByUUID(UUID uniqueId);

    Optional<Account> findByName(String name);

    void addAll(List<Account> accounts);

    void save(Account account);

    void remove(Account account);

}
