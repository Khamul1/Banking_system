package javabegin.ru.objects;

import javabegin.ru.interfaces.IBank;
import javabegin.ru.interfaces.IUser;

import java.util.Map;

public class Bank implements IBank<User> {
  private Map<String, User> users;

  public Bank(Map<String, User> users) {
    this.users = users;
  }

  @Override
  public void addUser(User user) {
    users.put(user.getId(), user);
  }

  @Override
  public void removeUser(User user) {
    users.remove(user.getId());
  }

  @Override
  public void depositMoney(User user, int amount) {
    if (user != null && amount > 0) {
      user.setBalance(user.getBalance() + amount);
    }
  }

  @Override
  public void withdrawMoney(User user, int amount) {
    if (user != null && amount > 0) {
      user.setBalance(user.getBalance() - amount);
    }
  }

  @Override
  public void transferMoney(User user1, User user2, int amount) {

    withdrawMoney(user1, amount);
    depositMoney(user2, amount);

  }

  @Override
  public Integer queryBalance(User user) {
    return user.getBalance();
  }
}
