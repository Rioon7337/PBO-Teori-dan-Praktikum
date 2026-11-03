package minggu4;

public class Account {
    private String ownerName;
    private double balance;

    public Account(String ownerName, double startingBalance) {
        this.ownerName = ownerName;
        if (startingBalance >= 0) {
            this.balance = startingBalance;
        } else {
            this.balance = 0;
            System.out.println("Saldo awal tidak boleh negatif!");
        }
    }

    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance = amount;
        } else {
            System.out.println("Error: Saldo tidak boleh negatif!");
        }
    }
}