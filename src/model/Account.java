package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String accountNumber;
    private final String currency;
    private double balance;
    private final List<OperationRecord> history;
    private final int historyCapacity;

    public Account(String accountNumber, String currency, int historyCapacity) {
        this.id = UUID.randomUUID();
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = 0.0;
        this.history = new ArrayList<>();
        this.historyCapacity = historyCapacity;
    }

    public UUID getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<OperationRecord> getHistory() {
        return history;
    }

    public int getHistorySize() {
        return history.size();
    }

    public void addHistoryRecord(OperationRecord record) {
        if (history.size() < historyCapacity) {
            history.add(record);
        }
    }
}
