/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Challange;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

import java.util.Scanner;

public class Validate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor kartu: ");
        String nomorKartu = scanner.nextLine().trim();

        // 1. Cek format penulisan (hanya digit atau format 4x4 dengan tanda hubung)
        if (!nomorKartu.matches("^(\\d{16}|\\d{4}-\\d{4}-\\d{4}-\\d{4})$")) {
            System.out.println("Nomor kartu tidak valid!");
            
            // Cek tipe kesalahan
            String murniDigit = nomorKartu.replace("-", "");
            if (!murniDigit.matches("\\d+")) {
                System.out.println("Kartu kredit hanya boleh berisi angka dan tanda hubung.");
            } else if (murniDigit.length() != 16) {
                System.out.println("Harus 16 digit.");
            } else {
                System.out.println("Format tanda hubung harus tepat setiap 4 digit (XXXX-XXXX-XXXX-XXXX).");
            }
        } 
        // 2. Cek digit pertama, harus dimulai dengan 4, 5, atau 6
        else if (!nomorKartu.startsWith("4") && !nomorKartu.startsWith("5") && !nomorKartu.startsWith("6")) {
            System.out.println("Nomor kartu tidak valid!");
            System.out.println("Harus dimulai dengan 4, 5, atau 6.");
        } 
        // 3. If all good
        else {
            System.out.println("Nomor kartu valid.");
        }

        scanner.close();
    }
}
