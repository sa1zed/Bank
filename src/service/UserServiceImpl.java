package service;

import model.Account;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    private List<User> users = new ArrayList<User>();

    @Override
    public User createUser(int id,String name, int maxAccounts){
        for(User user : users){
            if(user.getId() == id){
                throw new IllegalArgumentException("Пользователь с таким ID уже существует");
            }
        }
        User user = new User(id,name,maxAccounts);
        users.add(user);
        return user;
    }
    @Override
    public void printUserAccounts(User user){
        if(user.getAccountCount() ==0) {
            System.out.println("Нет аккаунтов");
            return;
        }
        for (Account account : user.getAccounts()) {
            System.out.println("Аккаунт: "+ account.getAccountNumber()+
                    ", валюта: "+account.getCurrency()+
                    ", баланс: "+account.getBalance());
        }
    }
}
