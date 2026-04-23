package service;

import CustomException.ThisUserAlredyExists;
import model.User;

public interface UserService {
    User createUser(int id, String name, int maxAccounts) throws ThisUserAlredyExists, ThisUserAlredyExists;
    void printUserAccounts(User user);
}
