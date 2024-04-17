package javabegin.ru.objects;

import java.util.UUID;

public class Account {
    private String id; // поле id класса Account
    private String currency; // поле currency класса Account
    private double balance; // поле balance класса Account

    public Account(String currency, double balance) {
        this.id = UUID.randomUUID().toString(); // генерирование уникального идентификатора
        this.currency = currency;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
