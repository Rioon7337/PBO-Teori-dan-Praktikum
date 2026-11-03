/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JCF;

/**
 *
 * @author ASUS
 */
import java.util.*;

public class JCF_Mix {
    public static void main(String[] args) {
        // Analisis Kode Lengkap Slide 6
        List<String> list = new ArrayList<>();
        list.add("Sari"); list.add("Budi"); list.add("Rina");
        list.remove("Budi"); // Menghapus "Budi", elemen "Rina" bergeser ke indeks 1
        System.out.println(list + " size=" + list.size()); // Output: [Sari, Rina] size=2

        Set<String> set = new HashSet<>(List.of("A", "B"));
        System.out.println(set.add("A") + " " + set.add("C")); // Output: false true

        Map<String, Integer> nilai = new HashMap<>();
        nilai.put("Sari", 90); 
        nilai.put("Budi", 80);
        nilai.put("Sari", 95); // MEMPERBARUI (OVERWRITE) nilai Kunci "Sari" yang sudah ada!
        System.out.println(nilai.get("Sari") + " " + nilai.size()); // Output: 95 2

    }
}
