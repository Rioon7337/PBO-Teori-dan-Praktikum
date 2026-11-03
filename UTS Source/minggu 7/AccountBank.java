package minggu7;

public class AccountBank {
    private double balance;

    public AccountBank(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws BalanceException {
        if (amount > balance) {
            throw new BalanceException("Saldo tidak mencukupi untuk penarikan Rp" + amount);
        } else {
            balance -= amount;
            System.out.println("Penarikan berhasil Rp" + amount + ". Sisa saldo: Rp" + balance);
        }
    }
}