package javabegin.ru;

import javabegin.ru.interfaces.IUser;
import javabegin.ru.objects.Bank;
import javabegin.ru.objects.User;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Инициализация системы пользователей
        Map<String, User> users = new HashMap<>();

        // Добавление пользователей для тестирования
        User user1 = new User("user1", "Popkov Vladimir Alexandrovich", new HashMap<>());
        user1.setBalance("USD", 1000);

        User user2 = new User("user2", "Lodochnik Anna Vladimirovna", new HashMap<>());
        user2.setBalance("RUB", 2000);

        users.put("user1", user1);
        users.put("user2", user2);

        // Создание и запуск сценариев транзакций
        Bank bank = new Bank(users);
        bank.withdrawMoney(user1, "USD", 500); // Пользователь 1 снимает 500
        bank.depositMoney(user2, "RUS", 1000); // Пользователь 2 добавляет 750
        bank.transferMoney(user1, "USD", user2, "RUS", 250); // Пользователь 1 переводит 250 пользователю 2

        // Проверка итогового баланса пользователей
        System.out.println("Balance of User 1: " + user1.getBalance("USD"));
        System.out.println("Balance of User 2: " + user2.getBalance("RUB"));
    }
}