package minggu3;

public class Box {
    double width;
    double height;
    double depth;

    // Default Constructor
    public Box() {
        this.width = 1;
        this.height = 1;
        this.depth = 1;
    }

    // Overloaded Constructor
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double computeVolume() {
        return width * height * depth;
    }
}