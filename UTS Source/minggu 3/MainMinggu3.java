package minggu3;

public class MainMinggu3 {
    public static void main(String[] args) {
        Element e1 = new Element("Hydrogen", 1, "H", 1.008, 1, 1);
        System.out.println("Element: " + e1.getName() + " (" + e1.getSymbol() + ")");

        Box b1 = new Box(10, 20, 15);
        System.out.println("Volume Box: " + b1.computeVolume());
    }
}