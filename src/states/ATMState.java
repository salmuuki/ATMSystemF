package states;

public interface ATMState {
    void authenticate();
    void checkBalance();
    void withdraw(double amount);
}
