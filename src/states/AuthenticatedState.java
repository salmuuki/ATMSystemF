package states;

import services.ATMService;

public class AuthenticatedState implements ATMState {
    private ATMService atmService;

    public AuthenticatedState(ATMService atmService) {
        this.atmService = atmService;
    }

    @Override
    public void authenticate() {
        System.out.println("Already authenticated.");
    }

    @Override
    public void checkBalance() {
        System.out.println("Checking balance...");
        atmService.checkBalance();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Processing withdrawal...");
        atmService.withdraw(amount);
    }
}
