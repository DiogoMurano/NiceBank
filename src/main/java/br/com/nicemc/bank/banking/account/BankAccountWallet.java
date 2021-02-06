package br.com.nicemc.bank.banking.account;

import br.com.nicemc.bank.banking.Currency;
import br.com.nicemc.bank.banking.currency.CurrencyType;
import dev.morphia.annotations.Transient;

import java.math.BigDecimal;

public class BankAccountWallet {

    private final Currency currency;
    private BigDecimal currentAmount;

    @Transient
    private BigDecimal rate;

    public BankAccountWallet(CurrencyType type) {
        currency = type.getCurrency();
        currentAmount = BigDecimal.valueOf(0);

        if (currency != null) {
            rate = BigDecimal.valueOf(type.getCurrency().getRate().doubleValue());
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return currentAmount;
    }

    public void add(BigDecimal value) {
        currentAmount = currentAmount.add(value.subtract(rate));
    }

    public void subtract(BigDecimal value) {
        currentAmount = currentAmount.subtract(value.subtract(rate));
    }

    public void multiply(BigDecimal value) {
        currentAmount = currentAmount.multiply(value.subtract(rate));
    }
}
