package service;

import model.User;

public interface UserService {
    User createUser(int id, String name, int maxAccounts);
    void printUserAccounts(User user);
}
