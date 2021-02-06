package br.com.nicemc.bank.banking.currency;

import br.com.nicemc.bank.banking.Currency;

import java.math.BigDecimal;

public enum CurrencyType {

    COINS(CurrencyBuilder.of("Coins")
            .withRate(new BigDecimal("1.09"))
            .withSymbol('c')
            .build()),;

    private final Currency currency;

    CurrencyType(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }
}