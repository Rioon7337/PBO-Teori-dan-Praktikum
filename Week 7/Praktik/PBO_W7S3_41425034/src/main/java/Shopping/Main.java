/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shopping;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.Scanner;

//Class main yang akan digunakan untuk menjalankan program java
public class Main {
    //pembuka yang memungkinkan JVM untuk mengeksekusi kode program
    public static void main(String[] args) {
        //mendeklarasikan objek input sebagai alat untuk menerima input dari user
        Scanner input = new Scanner(System.in);
        boolean berhasil = false;
        //membuat array dan mengisi array tersebut dengan daftar produk
        Produk[] daftarProduk = new Produk[5];
        daftarProduk[0] = new Produk("buku", 1000, 10);
        daftarProduk[1] = new Produk("pensil", 500, 20);
        daftarProduk[2] = new Produk("pulpen", 900, 15);
        daftarProduk[3] = new Produk("penghapus", 100, 0);
        daftarProduk[4] = new Produk("kalkulator", 1500, 5);
        
        Pembelian beli = new Pembelian();
        System.out.println("Silahkan masukkan barang yang mau anda beli: ");
        //melakukan input untuk mengisi nama produk yang akan dicari
        beli.namaProduk = input.nextLine();
        //try-catch-finally untuk mendeteksi error
        try {
            beli.cekProduk(daftarProduk);
            System.out.println("Silahkan masukkan jumlah barang " + beli.namaProduk + ": ");
            beli.jumlah = input.nextInt();
            beli.checkout(daftarProduk);
            berhasil = true;
        //catch yang digunakan untuk menangkap error custom BarangTidakAda
        } catch (BarangTidakAda e) {
            System.out.println("\n" + e.getMessage());
        //catch yang digunakan untuk menangkap error custom STokTidakCukup
        } catch (StokTidakCukup e) {
            System.out.println("\n" + e.getMessage());
        //catch yang digunakan untuk menangkap error custom StokKosong
        } catch(StokKosong e) {
            System.out.println("\n" + e.getMessage());
        //finally memiliki dua versi output yaitu jika proses try berhasil tanpa error dan jika ada error
        } finally {
            if(berhasil) {
                System.out.println("--------------------------------------------");
                System.out.println("Total belanja anda adalah Rp " + beli.total);
                System.out.println("\nProses pembelian telah selesai");
                System.out.println("Silahkan datang kembali");
            } else {
                System.out.println("--------------------------------------------");
                System.out.println("Mohon maaf atas ketidaknyamanannya kami akan segera menyediakan kebutuhan anda");
            }
            
        }
        
        
        
    }
}
