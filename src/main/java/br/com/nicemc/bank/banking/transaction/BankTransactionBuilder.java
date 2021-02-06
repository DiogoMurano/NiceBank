package br.com.nicemc.bank.banking.transaction;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class BankTransactionBuilder {

    private String[] notes;
    private BigDecimal afterAmount;
    private BigDecimal beforeAmount;

    public void setAfterAmount(BigDecimal afterAmount) {
        this.afterAmount = afterAmount;
    }

    public void setBeforeAmount(BigDecimal beforeAmount) {
        this.beforeAmount = beforeAmount;
    }

    public BankTransactionBuilder with(Consumer<BankTransactionBuilder> consumer) {
        consumer.accept(this);
        return this;
    }

    public void setNotes(String[] notes) {
        this.notes = notes;
    }

    public BankTransaction build() {
        return new BankTransaction(notes, afterAmount, beforeAmount);
    }
}