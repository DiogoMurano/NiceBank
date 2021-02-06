package br.com.nicemc.bank.inventory;

import br.com.nicemc.bank.account.Account;
import br.com.nicemc.bank.account.AccountType;
import br.com.nicemc.bank.banking.Currency;
import br.com.nicemc.bank.banking.account.BankAccountWallet;
import br.com.nicemc.bank.banking.currency.CurrencyType;
import br.com.nicemc.commons.builder.itemstack.SkullBuilder;
import br.com.nicemc.commons.inventory.ClickType;
import br.com.nicemc.commons.inventory.MenuBuilder;
import org.bukkit.entity.Player;

public class BankInventory {

    public void openInventory(Player player, Account account) {
        MenuBuilder menu = new MenuBuilder("Banco - Início", 3);

        BankAccountWallet wallet = account.getByCurrency(CurrencyType.COINS).getValue();
        Currency currency = wallet.getCurrency();

        AccountType accountType = AccountType.PERSONNALITE;

        menu.setItem(11, SkullBuilder.create()
                .owner(player)
                .name("§aSua conta no banco")
                .lore(lore -> {
                    lore.add("");
                    lore.add("§fModelo de conta: §b" + accountType.getName());
                    lore.add("§fTaxa por transação: §e" + currency.getRate() + "x");
                    lore.add("");
                    lore.add("§fRendimento fixo: §e" + accountType.getYield() + "%");
                    lore.add("§fRendimento a cada §e2 horas");
                }).build());

        menu.open(player);
    }
}
