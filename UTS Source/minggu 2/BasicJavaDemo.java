package minggu2;

import java.util.Scanner;

public class BasicJavaDemo {
    public static void main(String[] args) {
        // 1. Type Casting
        int angkaInt = 9;
        double angkaDouble = angkaInt; // Widening Casting (Implicit)
        double nilaiDesimal = 9.78;
        int nilaiBulat = (int) nilaiDesimal; // Narrowing Casting (Explicit)

        System.out.println("Casting Int to Double: " + angkaDouble);
        System.out.println("Casting Double to Int: " + nilaiBulat);

        // 2. Array 1D & Enhanced For
        int[] nilaiMhs = {80, 90, 75, 88};
        int total = 0;
        for (int n : nilaiMhs) {
            total += n;
        }
        double rataRata = (double) total / nilaiMhs.length;
        System.out.println("Rata-rata Nilai: " + rataRata);

        // 3. Array Multidimensi
        String[][] namaLengkap = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };
        System.out.println("Sapaan: " + namaLengkap[0][0] + namaLengkap[1][0]);

        // 4. Input Output (Scanner)
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama Anda: ");
        String namaInput = sc.nextLine();
        System.out.println("Halo, " + namaInput + "! Selamat belajar Java.");
    }
}