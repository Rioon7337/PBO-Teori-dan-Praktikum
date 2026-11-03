package minggu7;

// User-Defined Exception (Checked Exception)
public class BalanceException extends Exception {
    public BalanceException(String message) {
        super(message);
    }
}