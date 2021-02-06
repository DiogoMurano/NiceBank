package br.com.nicemc.bank.dependency;

import br.com.nicemc.commons.plugin.NicePlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultProviderImpl implements VaultProvider {

    private Economy economy;

    public VaultProviderImpl() {
        RegisteredServiceProvider<Economy> serviceProvider = NicePlugin
                .getPlugin().getServer().getServicesManager().getRegistration(Economy.class);
        if (serviceProvider == null) {
            return;
        }

        economy = serviceProvider.getProvider();
    }

    @Override
    public Economy getEconomy() {
        return economy;
    }
}
