package br.com.nicemc.bank.listener;

import br.com.nicemc.bank.BankPlugin;
import br.com.nicemc.bank.account.Account;
import br.com.nicemc.bank.account.AccountRepository;
import br.com.nicemc.bank.banking.account.BankAccount;
import br.com.nicemc.bank.banking.currency.CurrencyType;
import br.com.nicemc.bank.cache.AccountCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.Optional;

public class AccountListener implements Listener {

    private final AccountRepository accountRepository;
    private final AccountCache accountCache;

    public AccountListener(BankPlugin plugin) {
        accountRepository = plugin.getService(AccountRepository.class);
        accountCache = plugin.getService(AccountCache.class);

        accountCache.addAll(accountRepository.findAll());
    }

    @EventHandler
    public void onAsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {
        Optional<Account> optional = accountCache.findByName(event.getName());

        if (!optional.isPresent()) {
            Account account = new Account(event.getName());

            for (CurrencyType currencies : CurrencyType.values()) {
                account.addBankAccount(new BankAccount(currencies));
            }

            accountRepository.save(account);
            accountCache.save(account);
        }
    }
}
