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

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> daftar = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("=== Daftar Belanja ===");
            System.out.println("1. Tambah item");
            System.out.println("2. Hapus item");
            System.out.println("3. Tampilkan semua item");
            System.out.println("4. Cari item");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan item: ");
                    String itemBaru = scanner.nextLine();
                    daftar.add(itemBaru);
                    System.out.println(itemBaru + " berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Hapus item pada posisi: ");
                    int posisiHapus = scanner.nextInt();
                    if (posisiHapus > 0 && posisiHapus <= daftar.size()) {
                        String itemDihapus = daftar.remove(posisiHapus - 1);
                        System.out.println(itemDihapus + " berhasil dihapus!");
                    } else {
                        System.out.println("Posisi tidak valid!");
                    }
                    break;

                case 3:
                    System.out.println("Daftar belanja:");
                    if (daftar.isEmpty()) {
                        System.out.println("(Daftar belanja kosong)");
                    } else {
                        for (int i = 0; i < daftar.size(); i++) {
                            System.out.println((i + 1) + ". " + daftar.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.print("Cari item: ");
                    String itemCari = scanner.nextLine();
                    boolean ditemukan = false;
                    
                    for (int i = 0; i < daftar.size(); i++) {
                        if (daftar.get(i).equalsIgnoreCase(itemCari)) {
                            System.out.println(daftar.get(i) + " ditemukan pada posisi " + (i + 1));
                            ditemukan = true;
                            break;
                        }
                    }
                    
                    if (!ditemukan) {
                        System.out.println(itemCari + " tidak ditemukan dalam daftar.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    break;
            }
            System.out.println(); // Baris baru antar menu
        } while (pilihan != 5);

        scanner.close();
    }
}
