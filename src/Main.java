import CustomException.MaxAccount;
import CustomException.ThisUserAlredyExists;
import CustomException.UserNotFoundException;
import model.Account;
import model.User;
import service.*;

public class Main {
    public static void main(String[] args) throws ThisUserAlredyExists, UserNotFoundException, MaxAccount {
        System.out.println("Шаблон домашнего задания по банковской системе.");
        System.out.println("Сейчас в ветке main оставлены модели и интерфейсы, а реализации сервисов студент пишет сам.");

        User demoUser = new User(1,"Ivan",3);
        Account demoAccount = new Account("ACC-1001", "RUB", 10);
        demoUser.addAccount(demoAccount);

        System.out.println("Пример подготовленных данных:");
        System.out.println("Пользователь: " + demoUser.getName());
        System.out.println("Счет: " + demoAccount.getAccountNumber() + ", валюта: " + demoAccount.getCurrency());
        System.out.println("Количество счетов у пользователя: " + demoUser.getAccountCount());

//         Пример ожидаемого использования после реализации:
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
         UserService userService = new UserServiceImpl();
         AccountService accountService = new AccountServiceImpl();
         User user1 = userService.createUser(1, "Ivan", 3);
         Account salary = accountService.createAccount(user1, "ACC-1001", "RUB", 10);
         Account savings = accountService.createAccount(user1, "ACC-1002", "RUB", 10);
         accountService.deposit(salary, 1000);
         accountService.withdraw(salary, 200);
         accountService.transfer(salary, savings, 300);
         System.out.println(accountService.getBalance(salary));
         userService.printUserAccounts(user1);
         accountService.printStatement(salary);

//        UserService userService;
//        AccountService accountService;
//        userService = null;
//        accountService = null;

        if (userService == null || accountService == null) {
            System.out.println("Подсказка: реализуйте сервисы, затем подключите их в Main.");
        }
    }
}
