package javabegin.ru.objects;

import javabegin.ru.interfaces.IUser;

import java.util.Map;

public class User implements IUser {

  private String id;
  private String name;
  private Map<String, Integer> balances;

  public User(String id, String name, Map<String, Integer> balances) {
    this.id = id;
    this.name = name;
    this.balances = balances;
  }


  @Override
  public String getId() {
    return id;
  }

  @Override
  public int getBalance() {
    return 0;
  }

  public int getBalance(String currency) {
    return balances.getOrDefault(currency, 0);
  }

  public void setBalance(String currency, int balance) {
    balances.put(currency, balance);
  }
}