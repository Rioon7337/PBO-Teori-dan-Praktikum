/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanMandiri;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Konverter Waktu ===");
        System.out.println("1. Detik ke HH:MM:SS");
        System.out.println("2. HH:MM:SS ke detik");
        
        System.out.println("Pilihan: ");
        int pilihan = input.nextInt();
        
        if(pilihan == 1) {
            System.out.println("Masukkan jumlah detik: ");
            int awal = input.nextInt();
            int detik = awal % 60;
            int menit = (awal / 60) % 60;
            int jam = awal / 3600;
            System.out.println("Hasil: " + String.format("%02d", jam) + ":" + String.format("%02d", menit) + ":" + String.format("%02d", detik));
        } else if(pilihan == 2) {
            System.out.print("Masukkan waktu (HH:MM:SS): ");
                    String waktuInput = input.nextLine();

                    // Memisah string berdasarkan tanda titik dua ":"
                    String[] bagian = waktuInput.split(":");
                    
                    if (bagian.length == 3) {
                        int h = Integer.parseInt(bagian[0]);
                        int m = Integer.parseInt(bagian[1]);
                        int s = Integer.parseInt(bagian[2]);

                        int totalDetik = (h * 3600) + (m * 60) + s;
                        System.out.println("Hasil: " + totalDetik + " detik");
                    } else {
                        System.out.println("Format waktu salah! Gunakan format HH:MM:SS.");
                    }
        } else {
            System.out.println("Error! Input tidak valid");
        }
    }
}
