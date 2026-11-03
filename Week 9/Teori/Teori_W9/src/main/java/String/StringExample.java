/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package String;

/**
 *
 * @author ASUS
 */
// Contoh Kode Sifat Immutable String 
public class StringExample {
    public static void main(String[] args) {
        String nama = "Del";
        nama.concat("Institute of Technology");
        System.out.println(nama); // Output: Del (TIDAK BERUBAH!)

        nama = nama.concat("Institute of Technology");
        System.out.println(nama); // Output: Del Institute of Technology (OBJEK BARU!)
        
        // Contoh Hubungan String Pool dan Operator Perbandingan (Slide 10 & 11)
        char[] huruf = {'D', 'E', 'L'};
        String kata = new String(huruf); // Mengonversi char[] menjadi String

        String a = "Del";                // Disimpan di String Pool
        String b = "Del";                // Merujuk ke objek "Del" yang SAMA di String Pool
        String c = new String("Del");    // Dibuat eksplisit di memori Heap (di luar String Pool)

        System.out.println(a == b);       // Output: true  (Alamat memori di String Pool SAMA)
        System.out.println(a == c);       // Output: false (Alamat memori BERBEDA: Pool vs Heap)
        System.out.println(a.equals(c));  // Output: true  (Kandungan teks SAMA PERSIS)

    }
}

