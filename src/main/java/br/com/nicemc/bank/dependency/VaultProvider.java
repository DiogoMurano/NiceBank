package br.com.nicemc.bank.dependency;

import net.milkbowl.vault.economy.Economy;

public interface VaultProvider {

    Economy getEconomy();

}
