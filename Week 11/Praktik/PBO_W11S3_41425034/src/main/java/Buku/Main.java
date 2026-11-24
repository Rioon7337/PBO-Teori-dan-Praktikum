/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Buku;

/**
 *
 * @author ASUS
 */

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Buku[] daftarBuku = {
            new Buku("Tutorial Pemrograman"),
            new Buku("Java Programing Languange"),
            new Buku("Cara Manajemen Waktu"),
            new Buku("Programming 101"),
            new Buku("Programming for Dummies")
        };
        
        String[] daftarPengunjung = {"001", "002", "003", "004", "005"};
        
        try (ExecutorService poolPinjam = Executors.newFixedThreadPool(4)) {
            poolPinjam.submit(() -> {
                daftarBuku[1].pinjamBuku(daftarBuku[1].getJudul(), daftarPengunjung[1]);
            });
            poolPinjam.submit(() -> {
                daftarBuku[3].pinjamBuku(daftarBuku[3].getJudul(), daftarPengunjung[1]);
            });
            poolPinjam.submit(() -> {
                daftarBuku[1].pinjamBuku(daftarBuku[1].getJudul(), daftarPengunjung[0]);
            });
        }
        
        try (ExecutorService poolKembalikan = Executors.newFixedThreadPool(4)) {
            poolKembalikan.submit(() -> {
                daftarBuku[1].kembalikanBuku(daftarBuku[1].getJudul(), daftarPengunjung[1]);
            });
            poolKembalikan.submit(() -> {
                daftarBuku[3].kembalikanBuku(daftarBuku[3].getJudul(), daftarPengunjung[1]);
            });
            //percobaan ulang idPengunjung 001 meminjam buku
            poolKembalikan.submit(() -> {
                daftarBuku[1].pinjamBuku(daftarBuku[1].getJudul(), daftarPengunjung[0]);
            });
        }
        
        
    }
}
