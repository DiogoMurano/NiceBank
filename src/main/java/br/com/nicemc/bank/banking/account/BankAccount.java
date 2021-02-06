package br.com.nicemc.bank.banking.account;

import br.com.nicemc.bank.banking.currency.CurrencyType;
import br.com.nicemc.bank.banking.transaction.BankTransaction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class BankAccount {

    private final BankAccountWallet wallet;
    private final Set<BankTransaction> transactions;

    public BankAccount(CurrencyType currency) {
        this.transactions = new HashSet<>();
        this.wallet = new BankAccountWallet(currency);
    }

    public BankAccount() {
        this(CurrencyType.COINS);
    }

    public Set<BankTransaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(BankTransaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(UUID transactionId) {
        Optional<BankTransaction> transaction = transactions.stream()
                .filter(t -> t.getUuid().equals(transactionId))
                .findFirst();

        if (!transaction.isPresent()) {
            return;
        }

        transactions.remove(transaction.get());
    }

    public BankAccountWallet getValue() {
        return wallet;
    }

    public void add(BigDecimal value) {
        wallet.add(value);
    }

    public void subtract(BigDecimal value) {
        wallet.subtract(value);
    }

    public void multiply(BigDecimal value) {
        wallet.multiply(value);
    }
}