/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JCF;

/**
 *
 * @author ASUS
 */
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExample {
    public static void main(String[] args) {
        // Menggunakan LinkedList sebagai Queue (Antrean FIFO: First-In First-Out)
        Queue<String> antreanPinjam = new LinkedList<>();

        // 1. Mahasiswa mendaftar ke dalam antrean (Enqueue)
        antreanPinjam.add("Johannes (41425034)");
        antreanPinjam.add("Budi Utomo");
        antreanPinjam.add("Sari Rahayu");

        // 2. Melihat mahasiswa di barisan terdepan tanpa menghapusnya
        System.out.println("Mahasiswa terdepan: " + antreanPinjam.peek());

        // 3. Melayani mahasiswa terdepan (Dequeue - Menghapus dari depan)
        String dilayani = antreanPinjam.poll();
        System.out.println("Mahasiswa yang sedang melayani/pinjam: " + dilayani);

        // 4. Sisa antrean setelah pelayanan pertama
        System.out.println("Sisa antrean peminjaman: " + antreanPinjam);
    }
}


