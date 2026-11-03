package minggu4;

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat says: Meow... Meow...");
    }

    @Override
    public void move() {
        System.out.println("Cat walks silently.");
    }
}