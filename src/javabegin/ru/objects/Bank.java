package javabegin.ru.objects;

import javabegin.ru.interfaces.IBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements IBank<User> {
  private List<User> users;
  private Map<User, List<Account>> accounts; // добавлено поле для хранения счетов пользователей

  private String name;

  public Bank(String name, List<User> users) {
    this.name = name;
    this.users = users;
    this.accounts = new HashMap<>();
  }

  @Override
  public void addUser(User user) {
    users.add(user);
    accounts.put(user, new ArrayList<>()); // создаем пустой список счетов для нового пользователя
  }

  @Override
  public void depositMoney(User user, String currency, double amount) {
    if (user != null && amount > 0) {
      List<Account> userAccounts = accounts.get(user); // получаем список счетов пользователя
      for (Account existingAccount : userAccounts) {
        if (existingAccount.getCurrency().equals(currency)) {
          // У пользователя уже есть счет с такой же валютой
          return;
        }
      }

      double currentBalance = user.getBalance(currency);
      user.setBalance(currency, (int) (currentBalance + amount));

      Account newAccount = new Account(currency, amount); // создаем новый объект Account
      userAccounts.add(newAccount);
    }
  }

  @Override
  public void removeUser(User user) {
    users.remove(user);
    accounts.remove(user);
  }

  @Override
  public void depositMoney(User user, int amount) {

  }

  @Override
  public void withdrawMoney(User user, int amount) {

  }

  @Override
  public void transferMoney(User user1, User user2, int amount) {

  }

  @Override
  public Integer queryBalance(User user) {
    return null;
  }

  @Override
  public void depositMoney(User user, String currency, int amount) {
    if (user != null && amount > 0) {
      int currentBalance = user.getBalance(currency);
      user.setBalance(currency, currentBalance + amount);
    }
  }

  @Override
  public void withdrawMoney(User user, String currency, int amount) {
    if (user != null && amount > 0 && user.getBalance(currency) >= amount) {
      int currentBalance = user.getBalance(currency);
      user.setBalance(currency, currentBalance - amount);
    }
  }

  @Override
  public void transferMoney(User user1, String currency1, User user2, String currency2, int amount) {
    if (user1 != null && user2 != null && user1.getBalance(currency1) >= amount) {
      withdrawMoney(user1, currency1, amount);

      depositMoney(user2, currency2, amount);
    }
  }

  @Override
  public Integer queryBalance(User user, String currency) {
    return user.getBalance(currency);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}