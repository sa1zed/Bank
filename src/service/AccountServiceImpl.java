package service;

import CustomException.MaxAccount;
import CustomException.UserNotFoundException;
import model.Account;
import model.OperationRecord;
import model.OperationType;
import model.User;



public class AccountServiceImpl implements AccountService {
    @Override
    public Account createAccount (User user, String accountNumber,String currency, int historyCapacity) throws MaxAccount, UserNotFoundException {
        if(user == null){
            throw new UserNotFoundException("Такой пользователь не может существовать");
        }
        Account account = new Account(accountNumber,currency,historyCapacity);
        boolean added = user.addAccount(account);
        if(!added){
            throw new MaxAccount("Пользователь достиг максомального кол-ва учетных записей");
        }
        return account;
    }

    @Override
    public boolean deposit(Account account, double amount) {
        if(account == null || amount < 0){
            return false;
        }
        account.setBalance(account.getBalance()+amount);
        OperationRecord record = new OperationRecord(OperationType.DEPOSIT,amount, "Депозит: "+amount+" "+account.getCurrency());
        account.addHistoryRecord(record);
        return true;
    }
    @Override
    public boolean withdraw(Account account, double amount) {
        if (account == null || amount < 0|| amount > account.getBalance()||account.getBalance()<0) {
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        OperationRecord record = new OperationRecord(OperationType.WITHDRAW, amount, "Вывод: " + amount + " " + account.getCurrency());
        account.addHistoryRecord(record);
        return true;
    }
    @Override
    public boolean transfer(Account fromAccount, Account toAccount, double amount) {
        if(amount < 0|| amount > fromAccount.getBalance()){
            return false;
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        fromAccount.addHistoryRecord(new OperationRecord(OperationType.TRANSFER_OUT, amount, "Перевод ->"+toAccount.getAccountNumber()+
                ": "+amount+" "+fromAccount.getCurrency()));

        toAccount.setBalance(toAccount.getBalance() + amount);
        toAccount.addHistoryRecord(new OperationRecord(OperationType.TRANSFER_IN,amount,
                "Перевод от: "+fromAccount.getAccountNumber()+": "+ amount+" "+toAccount.getCurrency()));
        return true;

    }

    public double getBalance(Account account) {
        return account.getBalance();
    }

    public void printStatement(Account account) {
        System.out.println("Аккаунт: "+account.getAccountNumber()+
                ", валюта: "+account.getCurrency());
        System.out.println("Текущий баланс: "+account.getBalance());
        System.out.println("История счета: "+account.getHistorySize()+" записей");
        for(OperationRecord record: account.getHistory()){
            System.out.println(" "+record);
        }
    }
}


