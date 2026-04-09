package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final List<Account> accounts;
    private final int maxAccounts;

    public User(int id, String name, int maxAccounts) {
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
        this.maxAccounts = maxAccounts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public boolean addAccount(Account account) {
        if (accounts.size() >= maxAccounts) {
            return false;
        }

        accounts.add(account);
        return true;
    }
}
