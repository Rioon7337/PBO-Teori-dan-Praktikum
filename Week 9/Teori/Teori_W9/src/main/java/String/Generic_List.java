/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package String;

/**
 *
 * @author ASUS
 */
import java.util.*;

public class Generic_List {
    public static void main(String[] args) {
        // Skenario A: Tanpa Generics (Raw Type - Pendekatan Lama Berbahaya)
        List raw = new ArrayList();
        raw.add("teks"); // Memasukkan String
        raw.add(42);     // Memasukkan Integer (Autoboxing) -> Diterima sebagai Object!

        for (Object o : raw) {
            // Karena list menampung Object, kita harus me-cast ke String
            String s = (String) o; // Lolos kompilasi, TETAPI melempar ClassCastException saat elemen kedua (42) di-cast!
        }

        // Skenario B: Dengan Generics (Pendekatan Modern & Aman)
        List<String> l = new ArrayList<>();
        l.add("teks");
        // l.add(42); // ERROR KOMPILASI: incompatible types: int cannot be converted to String!

        String s = l.get(0); // Aman! Mengembalikan String langsung tanpa casting manual (String)

    }
}
