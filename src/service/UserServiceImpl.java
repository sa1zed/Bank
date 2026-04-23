package service;

import CustomException.ThisUserAlredyExists;
import model.Account;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    private List<User> users = new ArrayList<User>();

    @Override
    public User createUser(int id,String name, int maxAccounts) throws ThisUserAlredyExists {
        for(User user : users){
            if(user.getId() == id){
                throw new ThisUserAlredyExists("Пользователь с таким ID уже существует");
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
            System.out.println(String.format("Аккаунт: %s, валюта: %s, баланс: %.2f",
                    account.getAccountNumber(),
                    account.getCurrency(),
                    account.getBalance()));
        }
    }
}
