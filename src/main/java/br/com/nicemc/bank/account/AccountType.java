package br.com.nicemc.bank.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.MessageFormat;

@AllArgsConstructor
@Getter
public enum AccountType {

    EXPRESS("Express", "3"),
    PERSONNALITE("Personnalité", "5");

    private final String name;
    private final String yield;

    public BigDecimal getValue() {
        return new BigDecimal(MessageFormat.format("1.0{0}", yield));
    }

}
