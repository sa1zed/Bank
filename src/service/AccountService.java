package service;

import CustomException.MaxAccount;
import CustomException.UserNotFoundException;
import model.Account;
import model.User;

public interface AccountService {
    Account createAccount(User user, String accountNumber, String currency, int historyCapacity) throws MaxAccount, UserNotFoundException, MaxAccount, UserNotFoundException;
    boolean deposit(Account account, double amount);
    boolean withdraw(Account account, double amount);
    boolean transfer(Account from, Account to, double amount);
    double getBalance(Account account);
    void printStatement(Account account);
}
