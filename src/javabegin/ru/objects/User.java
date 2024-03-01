package javabegin.ru.objects;

import javabegin.ru.interfaces.IUser;

public class User implements IUser {

  private String id;
  private int balance;

  public User(String id, String name, int balance) {
    this.id = id;
    this.balance = balance;
  }

  @Override
  public String getId() {
    return id;
  }

  // Опционально можно добавить метод getBalance() для получения текущего баланса
  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setId(String id) {
    this.id = id;
  }
}
