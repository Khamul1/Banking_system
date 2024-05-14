package javabegin.ru.interfaces;

import javabegin.ru.objects.User;

public interface IBank<T extends IUser> {
    void addUser(T user);
    void removeUser(T user);
    void depositMoney(T user, String currency, int amount);
    void withdrawMoney(T user, String currency, int amount);
    void transferMoney(T user1, String currency1, T user2, String currency2, int amount);
    Integer queryBalance(T user, String currency);
}