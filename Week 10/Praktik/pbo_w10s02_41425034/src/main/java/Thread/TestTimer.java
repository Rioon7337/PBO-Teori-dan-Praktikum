/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

/**
 *
 * @author ASUS
 */
public class TestTimer {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" MEMULAI PROGRAM PENGINGAT PINTAR ");
        System.out.println("========================================\n");

        // Contoh 1: Pengingat makan sederhana
        System.out.println("1. PENGINGAT MAKAN SEDERHANA");
        Pengingat pengingatMakan = new Pengingat(3);

        // Tunggu sebentar untuk melihat hasil pengingat pertama
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Contoh 2: Pengingat dengan pesan custom dan repetisi
        System.out.println("\n2. PENGINGAT BELAJAR (Multiple)");
        Pengingat pengingatBelajar = new Pengingat(2, "Istirahatkan mata dan minum air!", 3);

        // Contoh 3: Pengingat olahraga
        System.out.println("\n3. PENGINGAT OLAHRAGA");
        Pengingat pengingatOlahraga = new Pengingat(4, "Waktunya stretching! Jangan duduk terlalu lama", 2);

        // Tunggu cukup lama untuk melihat semua pengingat
        System.out.println("\nMenunggu semua pengingat selesai...");
        try {
            Thread.sleep(15000); // Tunggu 15 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tampilkan status akhir
        System.out.println("\n\nLAPORAN AKHIR PROGRAM");
        System.out.println("----------------------------------------");
        pengingatMakan.tampilkanStatus();

        // Contoh penggunaan method batalkan
        System.out.println("\n4. CONTOH PEMBATALAN MANUAL");
        Pengingat pengingatBatal = new Pengingat(1, "Pesan ini akan dibatalkan", 5);
        try {
            Thread.sleep(3000);
            pengingatBatal.batalkanPengingat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== PROGRAM TESTER SELESAI ===");
    }
}
