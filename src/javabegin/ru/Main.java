package javabegin.ru;

import javabegin.ru.interfaces.IUser;
import javabegin.ru.objects.Bank;
import javabegin.ru.objects.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Инициализация системы пользователей
        List<User> users = new ArrayList<>();

        // Добавление пользователей для тестирования
        User user1 = new User("user1", "Popkov Vladimir Alexandrovich");
        user1.addBalance("USD", 1000);

        User user2 = new User("user2", "Lodochnik Anna Vladimirovna");
        user2.addBalance("RUB", 2000);

        users.add(user1);
        users.add(user2);

        // Вывод ФИО пользователей
        String userName1 = user1.getName();
        System.out.println("User 1 Name: " + userName1);

        String userName2 = user2.getName();
        System.out.println("User 2 Name: " + userName2);

        // Создание и запуск сценариев транзакций
        Bank bank = new Bank("Dodge", users);
        bank.setName("Dodge");
        bank.withdrawMoney(user1, "USD", 500); // Пользователь 1 снимает 500
        bank.depositMoney(user2, "RUB", 1000); // Пользователь 2 добавляет 750
        bank.transferMoney(user1, "USD", user2, "RUB", 250); // Пользователь 1 переводит 250 пользователю 2

        // Вывод названия банка
        System.out.println("Bank Name: " + bank.getName());

        // Проверка итогового баланса пользователей
        System.out.println("Balance of User 1: " + user1.getBalance("USD"));
        System.out.println("Balance of User 2: " + user2.getBalance("RUB"));
    }
}
