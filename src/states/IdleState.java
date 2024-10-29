package states;

import services.ATMService;

public class IdleState implements ATMState {
    private ATMService atmService;

    public IdleState(ATMService atmService) {
        this.atmService = atmService;
    }

    @Override
    public void authenticate() {
        System.out.println("Please enter PIN to authenticate.");
        // Hier könnte Logik hinzugefügt werden, um den Zustand zu wechseln, wenn die Authentifizierung erfolgt ist
    }

    @Override
    public void checkBalance() {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Please authenticate first.");
    }
}
