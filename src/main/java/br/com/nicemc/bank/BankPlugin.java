package br.com.nicemc.bank;

import br.com.nicemc.bank.account.AccountRepository;
import br.com.nicemc.bank.account.MongoAccountRepository;
import br.com.nicemc.bank.cache.AccountCache;
import br.com.nicemc.bank.cache.AccountCacheImpl;
import br.com.nicemc.bank.command.BankCommand;
import br.com.nicemc.bank.dependency.VaultProvider;
import br.com.nicemc.bank.dependency.VaultProviderImpl;
import br.com.nicemc.bank.listener.AccountListener;
import br.com.nicemc.commons.binders.module.Module;
import br.com.nicemc.commons.binders.module.ModuleDependency;
import br.com.nicemc.commons.plugin.BasePlugin;

@Module(name = "nice-bank", depends = {@ModuleDependency(name = "Vault", soft = true)})
public class BankPlugin extends BasePlugin {

    @Override
    public void load() {
    }

    @Override
    public void enable() {
//        provideService(VaultProvider.class, new VaultProviderImpl());
        provideService(AccountRepository.class, new MongoAccountRepository());
        provideService(AccountCache.class, new AccountCacheImpl());
        provideService(VaultProvider.class, new VaultProviderImpl());

        registerListener(new AccountListener(this));
        BankCommand.create();
    }

    @Override
    public void disable() {

    }
}
