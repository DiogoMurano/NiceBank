package br.com.nicemc.bank.account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {

    void save(Account account);

    List<Account> findAll();

    Optional<Account> findById(UUID id);

    Optional<Account> findByPlayerName(String playerName);

}
