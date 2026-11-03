/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JCF;

/**
 *
 * @author ASUS
 */
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Deklarasi Set untuk menampung NIM Mahasiswa yang unik
        Set<String> daftarNIM = new HashSet<>();

        // 1. Menambahkan NIM peserta
        daftarNIM.add("41425034");
        daftarNIM.add("41425001");
        daftarNIM.add("41425012");

        // 2. Mencoba menambahkan NIM duplikat
        boolean statusSama = daftarNIM.add("41425034"); // Akan menghasilkan false!
        System.out.println("Apakah NIM 41425034 berhasil ditambahkan lagi? " + statusSama);

        // 3. Memeriksa keberadaan suatu NIM (Search)
        if (daftarNIM.contains("41425012")) {
            System.out.println("NIM 41425012 terdaftar sebagai peserta praktikum.");
        }

        // 4. Menampilkan seluruh NIM (Urutan tidak dijamin sama dengan urutan add)
        System.out.println("Daftar NIM Unik Peserta: " + daftarNIM);
    }
}

