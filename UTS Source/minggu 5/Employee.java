package minggu5;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    // Abstract method
    public abstract double calculateSalary();
}