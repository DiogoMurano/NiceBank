package br.com.nicemc.bank.account;

import br.com.nicemc.bank.banking.account.BankAccount;
import br.com.nicemc.bank.banking.currency.CurrencyType;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.Data;
import org.apache.commons.lang.Validate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Account {

    @Id
    private UUID id;

    private String playerName;

    @Embedded
    private Set<BankAccount> bankAccounts;

    public Account(String playerName) {
        this.playerName = playerName;

        this.id = UUID.randomUUID();
        this.bankAccounts = new HashSet<>();
    }

    public Account() {
        this.bankAccounts = new HashSet<>();
    }

    public BankAccount getByCurrency(CurrencyType type) {
        return findByCurrency(type).orElseGet(() -> {
            BankAccount account = new BankAccount(type);
            addBankAccount(account);
            return account;
        });
    }

    public Optional<BankAccount> findByCurrency(CurrencyType type) {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getValue().getCurrency().equals(type.getCurrency()))
                .findAny();
    }

    public void addBankAccount(BankAccount account) {
        Validate.notNull(account, "account can't be null.");
        this.bankAccounts.add(account);
    }
}
