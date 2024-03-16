package javabegin.ru.objects;

import javabegin.ru.interfaces.IUser;

import java.util.HashMap;
import java.util.Map;

public class User implements IUser {

  private String id;
  private String name;

  private Map<String, Integer> balances;

  public User(String id, String name) {
    this.id = id;
    this.name = name;
    this.balances = new HashMap<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addBalance(String currency, int balance) {
    balances.put(currency, balance);
  }

  public int getBalance(String currency) {
    return balances.getOrDefault(currency, 0);
  }

  @Override
  public void setBalance(String code, int balance) {

  }
}
