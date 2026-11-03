package minggu5;

public class MainMinggu5 {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Alice", 5000000, 1500000);
        Employee e2 = new PartTimeEmployee("Bob", 50000, 80);

        Employee[] employees = {e1, e2};

        for (Employee emp : employees) {
            System.out.println("Karyawan: " + emp.getName() + " | Gaji: Rp" + emp.calculateSalary());
        }
    }
}