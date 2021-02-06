package br.com.nicemc.bank.banking;

import lombok.Getter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.math.BigDecimal;

@Getter
public final class Currency {

    private final String name;
    private final char symbol;
    private final BigDecimal rate;

    public Currency(String name, char symbol, BigDecimal rate){
        this.name = name;
        this.symbol = symbol;
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return new EqualsBuilder().append(symbol, currency.symbol).append(name, currency.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(symbol).toHashCode();
    }
}