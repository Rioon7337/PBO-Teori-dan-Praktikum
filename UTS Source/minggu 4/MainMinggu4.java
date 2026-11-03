package minggu4;

public class MainMinggu4 {
    public static void main(String[] args) {
        Account acc = new Account("Johannes", 50000);
        acc.setBalance(-9999); // Ditolak oleh setter

        Animal myCat = new Cat();
        myCat.makeSound();
        myCat.move();
    }
}