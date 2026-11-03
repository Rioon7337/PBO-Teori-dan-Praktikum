/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JCF;

/**
 *
 * @author ASUS
 */
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Memetakan Kode Alat (String) ke Nama Detail Alat (String)
        Map<String, String> petaAlat = new HashMap<>();

        // 1. Memasukkan data pasangan Kode -> Nama Alat (put)
        petaAlat.put("E101", "Multimeter Sanwa CD800a");
        petaAlat.put("M202", "Obeng Set Precision");
        petaAlat.put("O303", "Mikroskop Binokuler");

        // 2. Mengambil data alat secara langsung berdasarkan kodenya
        String namaAlat = petaAlat.get("M202");
        System.out.println("Alat dengan Kode M202: " + namaAlat);

        // 3. Memperbarui data (Overwrite) dengan Kunci yang sama
        petaAlat.put("E101", "Multimeter Aneng Digital Pro"); // Nilai lama ditimpa!

        // 4. Iterasi menampilkan seluruh pasangan Key-Value
        System.out.println("\n--- Daftar Seluruh Alat di Laboratorium ---");
        for (Map.Entry<String, String> entry : petaAlat.entrySet()) {
            System.out.println("Kode: " + entry.getKey() + " -> Alat: " + entry.getValue());
        }
    }
}
