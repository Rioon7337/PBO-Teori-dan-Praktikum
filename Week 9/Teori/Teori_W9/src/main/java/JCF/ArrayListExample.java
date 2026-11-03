/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package JCF;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Deklarasi ArrayList dengan Generics <String>
        List<String> katalogAlat = new ArrayList<>();

        // 1. Menambahkan elemen ke dalam ArrayList
        katalogAlat.add("Multimeter Digital");
        katalogAlat.add("Oscilloscope");
        katalogAlat.add("Solder Listrik");
        katalogAlat.add("Multimeter Digital"); // Duplikat diperbolehkan

        // 2. Mengakses elemen berdasarkan indeks
        System.out.println("Alat pada indeks ke-1: " + katalogAlat.get(1)); // Oscilloscope

        // 3. Mengubah elemen pada indeks tertentu
        katalogAlat.set(2, "Solder Stasiun Blower");

        // 4. Menghapus elemen berdasarkan nilai
        katalogAlat.remove("Multimeter Digital"); // Menghapus kemunculan pertama

        // 5. Menampilkan seluruh elemen dan ukuran List
        System.out.println("Isi Katalog Alat: " + katalogAlat);
        System.out.println("Jumlah Alat Terdaftar: " + katalogAlat.size());
    }
}

