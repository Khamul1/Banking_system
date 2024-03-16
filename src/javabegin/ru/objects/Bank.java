package javabegin.ru.objects;

import javabegin.ru.interfaces.IBank;
import javabegin.ru.interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank<User> {
  private List<User> users;
  private String name;


  public Bank(String name, List<User> users) {
    this.users = users;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  @Override
  public void addUser(User user) {
    users.add(user);
  }

  @Override
  public void removeUser(User user) {
    users.remove(user);
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
}
