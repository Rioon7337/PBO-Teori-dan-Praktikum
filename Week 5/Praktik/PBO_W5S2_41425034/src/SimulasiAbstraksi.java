/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

abstract class KendaraanEkspedisi {
    protected String noPolisi;
    protected int kapasitasKg;

    public KendaraanEkspedisi(String noPolisi, int kapasitasKg) {
        this.noPolisi = noPolisi;
        this.kapasitasKg = kapasitasKg;
    }

    // Concrete method: bisa langsung diwarisi
    public void infoKendaraan() {
        System.out.println("Plat Nomor: " + noPolisi
                + " | Daya Angkut: " + kapasitasKg + " Kg");
    }

    // Abstract method: WAJIB diimplementasi subclass konkret
    public abstract void angkutBarang(String namaBarang);
}

// Subclass dari KendaraanEkspedisi
class TrukBox extends KendaraanEkspedisi {
    public TrukBox(String noPolisi, int kapasitasKg) {
        super(noPolisi, kapasitasKg);
    }

    @Override
    public void angkutBarang(String namaBarang) {
        System.out.println("Truk [" + noPolisi + "] memuat " + namaBarang
                + " ke dalam kontainer tertutup pendingin.");
    }
}

// Subclass konkret 2: MobilVan
class MobilVan extends KendaraanEkspedisi {
    public MobilVan(String noPolisi, int kapasitasKg) {
        super(noPolisi, kapasitasKg);
    }

    @Override
    public void angkutBarang(String namaBarang) {
        System.out.println("Mobil Van [" + noPolisi + "] memuat " + namaBarang
                + " di bagasi belakang untuk distribusi kota.");
    }
}

public class SimulasiAbstraksi {
    public static void main(String[] args) {
        System.out.println("=== INI ABSTRACT CLASS ===");

        // PERCOBAAN 1: Menguji larangan instansiasi langsung abstract class
        //KendaraanEkspedisi k = new KendaraanEkspedisi("BK 1234 DEL", 100);

        // PERCOBAAN 2: Instansiasi dari subclass konkret
        TrukBox fuso = new TrukBox("B 9081 TXT", 5000);
        fuso.infoKendaraan();
        fuso.angkutBarang("20 Unit Kulkas");

        System.out.println("--------------------------------------------");

        MobilVan grandmax = new MobilVan("B 1122 KAA", 800);
        grandmax.infoKendaraan();
        grandmax.angkutBarang("50 Kotak Sepatu");

        // Tugas tambahan: array polimorfisme
        System.out.println("\n=== POLIMORFISME ARRAY ===");
        KendaraanEkspedisi[] armada = {
            new TrukBox("B 1111 AA", 4000),
            new MobilVan("B 2222 BB", 700),
            new TrukBox("B 3333 CC", 6000)
        };

        for (KendaraanEkspedisi kendaraan : armada) {
            kendaraan.infoKendaraan();
            kendaraan.angkutBarang("Paket Campuran");
            System.out.println("---");
        }
    }
}

/*
1. Uncompilable code - KendaraanEkspedisi is abstract; cannot be instantiated
Baris kode ini gagal dikarenakan sistem mencoba melakukan instansiasi pada class abstract
dimana class abstract memiliki sifat tidak dapat berdiri sendiri karena hanya berfungsi
sebagai kerangka untuk kelas yang lain.
2. Saat saya menagarahkan kursor dan mengklik Alt + Enter tidak ada opsi perbaikan yang 
diberikan. Namun jika melihat dari error message yang diberikan dapat kita seimpulkan bahwa 
class MotorKurir bukan suatu class abstract dan tidak melakuan override pada method
angkutBarang().
*/