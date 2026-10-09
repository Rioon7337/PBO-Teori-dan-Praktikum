/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

// ProgramOverriding (Runtime Polymorphism)
class KurirReguler {
    protected String nama;

    public KurirReguler(String nama) {
        this.nama = nama;
    }

    // Method parent: jalur darat
    public void kirimBarang(String alamat) {
        System.out.println(nama + " mengantar paket ke " + alamat
                + " lewat jalur darat menembus kemacetan.");
    }
}

class KurirDrone extends KurirReguler {
    private String idDrone;

    public KurirDrone(String nama, String idDrone) {
        super(nama);
        this.idDrone = idDrone;
    }

    // @Override: validasi compiler + cegah salah ketik
    @Override
    public void kirimBarang(String alamat) {
        System.out.println("Unit Drone [" + idDrone + "] operator " + nama
                + " terbang mengantar paket langsung ke koordinat: " + alamat);
    }
}

public class SimulasiOverriding {
    public static void main(String[] args) {
        System.out.println("=== INI METHOD OVERRIDING ===");
        KurirReguler k1 = new KurirReguler("Budi");
        KurirReguler k2 = new KurirDrone("Arka", "DRN-01"); // upcasting

        // JVM pilih method berdasarkan objek asli (runtime)
        k1.kirimBarang("Jl. Sudirman No. 10");
        k2.kirimBarang("Gedung Graha Lt. 5");
    }
}

/*
1. Hasil yang diberikan adalah lewat jalur darat mengikuti class parent dikarenakan 
Override hanya mengubah method dengan nama yang sama, selain itu ketika dipanggil 
yanbg dipanggil adalah method kirimBarang bukan kirimbarang.
2. Uncompilable code - method does not override or implement a method from a supertype.
3. Fungsi @Override digunakan untuk mengubah isi method yang memiliki nama yang sama 
antara class parent dan class anak.
*/