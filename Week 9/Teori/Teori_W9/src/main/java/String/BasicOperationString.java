/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package String;

/**
 *
 * @author ASUS
 */
public class BasicOperationString {
    public static void main(String[] args) {
        // Contoh Operasi String Lengkap (Slide 14)
        String nama = "Del Institute";
        String nama1 = "KACA";

        // 1. Substring: mengambil potongan string dari indeks start (0) hingga sebelum end (3)
        System.out.println(nama.substring(0, 3)); // Output: Del

        // 2. Case Conversion: mengubah seluruh huruf menjadi kapital
        System.out.println(nama.toUpperCase());    // Output: DEL INSTITUTE
        System.out.println(nama.toLowerCase());
        System.out.println(nama.replace("e", "E"));
        System.out.println("00 " + nama1.substring(0,1)+ nama1.substring(1, 2).toLowerCase()
                .concat(nama1.substring(2, nama1.length())));

        // 3. Equals: membandingkan isi teks (case-sensitive)
        System.out.println(nama.equals("del"));     // Output: false
        System.out.println("SMA".equals("sma")); 
        System.out.println("DEL".equals("del")); 
        System.out.println("LED".equalsIgnoreCase("del")); 
        // 4. Parsing: mengubah String berisi angka menjadi tipe primitif int
        int angka = Integer.parseInt("123");       // Hasil: 123 (int)
        System.out.println(angka + 100);

        // 5. Casting/Conversion: mengubah tipe primitif menjadi String
        String teksAngka = String.valueOf(123);    // Hasil: "123" (String)
        System.out.println(teksAngka + 100);
        /*
        String[] arr =  new String[2];
        arr[0] = "Rina";
        arr[1] = "Budi";
        arr[2] = "Sari";
        */
    }
}
