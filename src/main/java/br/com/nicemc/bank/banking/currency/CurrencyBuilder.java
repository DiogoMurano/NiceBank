package br.com.nicemc.bank.banking.currency;

import br.com.nicemc.bank.banking.Currency;

import java.math.BigDecimal;

public class CurrencyBuilder {

    private final String name;
    private char symbol;
    private BigDecimal rate;

    private CurrencyBuilder(String name) {
        this.name = name;
    }

    public static CurrencyBuilder of(String name){
        return new CurrencyBuilder(name);
    }

    public CurrencyBuilder withSymbol(char symbol){
        this.symbol = symbol;
        return this;
    }

    public CurrencyBuilder withRate(BigDecimal rate){
        this.rate = rate;
        return this;
    }

    public Currency build(){
        return new Currency(name, symbol, rate);
    }
}