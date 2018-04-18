package account;

public interface Account {

    void transfer(Account person, double amount);

    void withdraw(double amount);

    void deposit(double amount);

    void showInfo();
}
