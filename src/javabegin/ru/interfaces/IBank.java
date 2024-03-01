package javabegin.ru.interfaces;

public interface IBank<T extends IUser> {

    void addUser(T user); // добавить пользователя
    void removeUser(T user); // удалить пользователя
    void depositMoney(T user, int amount); // Банк обрабатывает вклад пользователя
    void withdrawMoney(T user, int amount); // Банк обратаывает снятие денег
    void transferMoney(T user1, T user2, int amount); // Банк обрабатывает перевод между пользователями
    Integer queryBalance(T user); //информация о балансе пользователя
}
