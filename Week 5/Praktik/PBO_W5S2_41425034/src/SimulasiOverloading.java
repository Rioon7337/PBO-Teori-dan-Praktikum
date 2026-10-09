/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

// Program Overloading (Compile-Time Polymorphism)
class MesinTarif {
    private String kotaAsal;
    
    public MesinTarif(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }
    
    // Overload 1: berat
    public double hitungOngkir(double beratKg) {
        return beratKg * 10000;
    }
    
    // Overload 2: berat + asuransi
    public double hitungOngkir(double beratKg, double nilaiBarang) {
        double biayaAsuransi = nilaiBarang * 0.01;
        return (beratKg * 10000) + biayaAsuransi;
    }
    
    // Overload 3: berat + express
    public double hitungOngkir(double beratKg, boolean isExpress) {
        double total = beratKg + 10000;
        if (isExpress) total += 20000;
        return total;
    }
}

public class SimulasiOverloading {
    public static void main(String[] args) {
        System.out.println("=== INI METHOD OVERLOADING ===");
        MesinTarif tarif = new MesinTarif("Medan");
        
        // Compiler pilih method sesuai dengan parameter
        System.out.println("Ongkir Biasa(2.0Kg)            : Rp " + tarif.hitungOngkir(2.0));
        System.out.println("Ongkir + Asuransi (Barang 50Jt): Rp " + tarif.hitungOngkir(2.0, 50000000));
        System.out.println("Ongkir Express (2,0Kg)         : " + tarif.hitungOngkir(2.0, true));
    }
}

/*
1. Karena ketika compiler menemukan beberapa method yang sama maka compiler akan menentukan method  mana yang dipanggil
   dengan melihat parameter yang ada di method tersebut.
2. Hal ini terjadi dikarenakan compiler mengecek parameter dari suatu method dengan nama yang sama bukan dari nilai yang 
   akan dikembalikan.
 */
