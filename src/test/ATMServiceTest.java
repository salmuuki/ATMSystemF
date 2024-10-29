import models.Account;
import auth.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMServiceTest {
    private ATMService atmService;
    private Account account;
    private AuthenticationService authService;

    @BeforeEach
    void setUp() {
        account = new Account("123456", 1000.0);
        authService = new AuthenticationService("1234");
        atmService = new ATMService(authService, account);
    }

    @Test
    void testAuthenticationSuccess() {
        atmService.authenticate("1234");
        atmService.checkBalance();
        // Erwartung: Der Kontostand sollte angezeigt werden
    }

    @Test
    void testAuthenticationFailure() {
        atmService.authenticate("0000");
        atmService.checkBalance();
        // Erwartung: Eine Fehlermeldung zur Authentifizierung sollte angezeigt werden
    }

    @Test
    void testWithdrawSuccess() {
        atmService.authenticate("1234");
        atmService.withdraw(200.0);
        assertEquals(800.0, account.getBalance());
        // Erwartung: Der neue Kontostand sollte 800.0 sein
    }

    @Test
    void testWithdrawInsufficientFunds() {
        atmService.authenticate("1234");
        atmService.withdraw(1200.0);
        assertEquals(1000.0, account.getBalance());
        // Erwartung: Der Kontostand bleibt unverändert, da das Guthaben nicht ausreicht
    }
}
