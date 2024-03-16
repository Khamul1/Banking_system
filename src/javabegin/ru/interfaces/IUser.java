package javabegin.ru.interfaces;

public interface IUser {
    String getId(); // получить идентификатор пользователя
    String getName(); // получить имя пользователя
    int getBalance(String code); // получить баланс по указанному коду валюты
    void setBalance(String code, int balance); // установить баланс для указанного кода валюты
}
