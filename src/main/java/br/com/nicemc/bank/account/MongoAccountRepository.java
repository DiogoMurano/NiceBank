package br.com.nicemc.bank.account;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MongoAccountRepository implements AccountRepository {

    private final Datastore datastore;

    public MongoAccountRepository() {
        Morphia morphia = new Morphia();
        morphia.map(Account.class);

        datastore = morphia.createDatastore(new MongoClient(
                new ServerAddress("127.0.0.1", 27017)
        ), "bank_accounts");
        datastore.ensureIndexes();
    }

    @Override
    public void save(Account account) {
        datastore.save(account);
    }

    @Override
    public List<Account> findAll() {
        return datastore.createQuery(Account.class)
                .find()
                .toList();
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return Optional.ofNullable(datastore.createQuery(Account.class)
                .field("id")
                .equal(id)
                .find()
                .tryNext());
    }

    @Override
    public Optional<Account> findByPlayerName(String playerName) {
        return Optional.ofNullable(datastore.createQuery(Account.class)
                .field("playerName")
                .equal(playerName)
                .find()
                .tryNext());
    }
}
