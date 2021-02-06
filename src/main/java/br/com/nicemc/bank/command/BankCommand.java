package br.com.nicemc.bank.command;

import br.com.nicemc.bank.account.Account;
import br.com.nicemc.bank.cache.AccountCache;
import br.com.nicemc.bank.inventory.BankInventory;
import br.com.nicemc.commons.Commands;
import br.com.nicemc.commons.Services;

import java.util.Optional;

public class BankCommand {

    public static void create() {

        AccountCache accountCache = Services.load(AccountCache.class);
        BankInventory bankInventory = new BankInventory();

        Commands.create().assertPlayer().handler((context, player, label, args) -> {
            Optional<Account> optional = accountCache.findByName(player.getName());
            if (optional.isPresent()) {
                if (args.isEmpty()) {
                    bankInventory.openInventory(player, optional.get());
                }
            }
        }).register("bank", "banco");


    }

}
