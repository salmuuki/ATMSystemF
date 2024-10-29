package auth;

public class AuthenticationService {
    private String correctPin;

    public AuthenticationService(String correctPin) {
        this.correctPin = correctPin;
    }

    public boolean authenticateUser(String inputPin) {
        return inputPin.equals(correctPin);
    }
}
