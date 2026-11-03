package minggu5;

public class FullTimeEmployee extends Employee {
    private double basicSalary;
    private double allowance;

    public FullTimeEmployee(String name, double basicSalary, double allowance) {
        super(name);
        this.basicSalary = basicSalary;
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance;
    }
}