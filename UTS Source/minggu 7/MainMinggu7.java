package minggu7;

public class MainMinggu7 {
    public static void main(String[] args) {
        AccountBank bankAcc = new AccountBank(50000);

        try {
            System.out.println("Mencoba menarik Rp70.000...");
            bankAcc.withdraw(70000);
        } catch (BalanceException e) {
            System.out.println("Pesan Error (Caught): " + e.getMessage());
        } finally {
            System.out.println("Blok finally: Transaksi selesai diproses.\n");
        }
    }
}