package br.com.nicemc.bank.banking.transaction;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
public class BankTransaction {

    private final UUID uuid;
    private final Date creationDate;
    private final String[] notes;

    private final BigDecimal afterAmount;
    private final BigDecimal beforeAmount;

    public BankTransaction(String[] notes, BigDecimal afterAmount, BigDecimal beforeAmount) {
        this.notes = notes;
        this.afterAmount = afterAmount;
        this.beforeAmount = beforeAmount;

        this.uuid = UUID.randomUUID();
        this.creationDate = new Date();
    }
}