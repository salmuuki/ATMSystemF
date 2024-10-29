package services;

import auth.AuthenticationService;
import models.Account;
import states.ATMState;
import states.IdleState;
import states.AuthenticatedState;

public class ATMService {
    private AuthenticationService authService;
    private Account userAccount;
    private ATMState currentState;

    public ATMService(AuthenticationService authService, Account userAccount) {
        this.authService = authService;
        this.userAccount = userAccount;
        this.currentState = new IdleState(this);  // Startzustand ist Idle
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public void authenticate(String pin) {
        if (authService.authenticateUser(pin)) {
            System.out.println("Authentication successful.");
            setState(new AuthenticatedState(this));
        } else {
            System.out.println("Authentication failed.");
        }
    }

    public void checkBalance() {
        currentState.checkBalance();
    }

    public void withdraw(double amount) {
        currentState.withdraw(amount);
    }
}
