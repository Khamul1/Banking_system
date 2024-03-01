package javabegin.ru;

import javabegin.ru.interfaces.IUser;
import javabegin.ru.objects.Bank;
import javabegin.ru.objects.User;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Инициализация системы пользователей

            // Инициализация системы пользователей
            Map<String, User> users = new HashMap<>();

            // Добавление пользователей для тестирования
            users.put("user1", new User("user1", "Popkov Vladimir Alexandrovich", 1000));
            users.put("user2", new User("user2", "Lodochnik Anna Vladimirovna", 2000));

            // Создание и запуск сценариев транзакций
            Bank bank = new Bank(users);
            bank.withdrawMoney(users.get("user1"), 500);  // Пользователь 1 снимает 500
            bank.depositMoney(users.get("user2"), 500);   // Пользователь 2 добавляет 500
            bank.transferMoney(users.get("user1"), users.get("user2"), 250); // Пользователь 1 переводит 250 пользователю 2

            // Проверка итогового баланса пользователей
            System.out.println("Balance of User 1: " + users.get("user1").getBalance());
            System.out.println("Balance of User 2: " + users.get("user2").getBalance());
        }
    }