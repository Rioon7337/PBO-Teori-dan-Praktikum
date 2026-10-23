/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shopping;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

public class Pembelian {
    public String namaProduk;
    public int jumlah;
    double total;
    
    //method yang digunakan untuk mendeteksi nama produk yang dimasukkan user ada atau tidak
    public void cekProduk(Produk[] daftarProduk) throws BarangTidakAda, StokKosong{
        boolean ketersediaan = false;
        for(Produk p: daftarProduk) {
            if(p.nama.equalsIgnoreCase(namaProduk)) {
                boolean ada = true;
                if(ada == true) {
                    ketersediaan = ada;
                }
            }
            
            //percabangan yang dilakukan untuk mengecek apakah stok dari produk yang dicari ada atau tidak
            if (ketersediaan == true && p.stok > 1 && p.nama.equalsIgnoreCase(namaProduk)) {
                System.out.println("\nLoading...");
                System.out.println("Produk yang anda cari tersedia.");
            }else if(ketersediaan == true && p.stok <= 1 && p.nama.equalsIgnoreCase(namaProduk)) {
                System.out.println("\nLoading...");
                //Error yang di throw jika barang tidak cukup
                throw new StokKosong("Mohon maaf produk yang anda cari sudah habis");
            }
        }
      
        if (ketersediaan != true) {
            System.out.println("\nLoading...");
            //jika tidak ada produk yang diinginkan user maka sistem akan melakukan throw
            throw new BarangTidakAda("Mohon maaf barang tidak ditemukan.");
        }
    }
    
    //method yang digunakan untuk menghitung total belanja
    public double checkout(Produk[] daftarProduk) throws StokTidakCukup{
        total = 0;
        int harga = 0;
        boolean ketersediaan = false;
        for(Produk p: daftarProduk) {
            if(p.nama.equalsIgnoreCase(namaProduk)) {
                boolean ada = true;
                if(ada == true) {
                    ketersediaan = ada;
                    harga = p.harga;
                }
            }
            
            //percabangan untuk megecek apakah banyak stok lebih banyak dari jumlah yang dibeli
            if (ketersediaan == true && p.stok > jumlah && p.stok > 1 && p.nama.equalsIgnoreCase(namaProduk)) {
                total = total + harga * jumlah;
            } else if (ketersediaan == true && p.stok < jumlah && p.nama.equalsIgnoreCase(namaProduk)) {
                throw new StokTidakCukup("Stok tidak mencukupi.");
            }
        }
        return total;
    }
}
