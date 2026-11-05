/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbo_w9s2_41425034;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 Teknologi Rekayasa Perangkat Lunak
*/

import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        String text = " Hello World! Welcome to Java Programming ";
        System.out.println("=== BASIC STRING OPERATIONS ===");
        //Percobaan startsWith
        System.out.println(text.startsWith("Hello")); // hasil: false
        System.out.println(text.startsWith(" ")); //hasil: true
        System.out.println("Original: '" + text + "'");
        System.out.println("Length: " + text.length());
        //.trim() digunakan untuk menghapus spaasi di awal dan di akhir
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("Uppercase: '" + text.toUpperCase() + "'");
        System.out.println("Lowercase: '" + text.toLowerCase() + "'");

        // Substring dan indexing
        System.out.println("\n=== SUBSTRING & INDEXING ===");
        System.out.println("Character at index 5: '" + text.charAt(5) + "'");
        System.out.println("Substring (7-12): '" + text.substring(7, 12) + "'");
        System.out.println("Index of 'World': " + text.indexOf("World"));
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));

        // Replacement dan comparison
        System.out.println("\n=== REPLACEMENT & COMPARISON ===");
        System.out.println("Replace 'Java' with 'Python': '" + text.replace("Java", "Python") + "'");
        System.out.println("Contains 'Programming': " + text.contains("Programming"));
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        System.out.println("Ends with 'Programming': " + text.endsWith("Programming"));

        // Split dan join
        System.out.println("\n=== SPLIT & JOIN ===");
        String[] words = text.trim().split(" ");
        System.out.println("Number of words: " + words.length);
        System.out.print("Words: ");
        for (String word : words) {
            System.out.print("[" + word + "] ");
        }
        System.out.println();

        // StringBuilder untuk efisiensi
        System.out.println("\n=== STRING BUILDER ===");
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(" Programming");
        sb.insert(0, "Learn ");
        sb.reverse();
        System.out.println("Reversed: " + sb.toString());
        
        //Mengambil kata Java
        String kata = "Java";
        int start = text.indexOf(kata);
        int end = kata.length(); 
        System.out.println("Mengambil kata Java: " + text.substring(start, start + end));
        
        //Modifikasi
        //Hanya menampilkan kata lebih dari 4
        System.out.println("\n=== MENAMPILKAN LEBIH DARI 4 HURUF ===");
        //Mengubah isi variabel text menjadi array per kata
        String[] kata4 = text.trim().split("\\s+");
        //loop untuk print setiap isi dari array kata4 dengan kondisi
        for(String word : kata4) {
            //menghilangkan semua karakter yang bukan huruf
            String onlyWord = word.replaceAll("[^a-zA-Z]", "");
            if (onlyWord.length() > 4) {
                System.out.print(onlyWord + " ");
            }
        }
        
        //Menghitung jumlah huruf vokal
        System.out.println("\n=== MENGHITUNG HURUF VOKAL ===");
        int count = 0;
        //Membuat isi variabel text menjadi huruf kecil semua
        String lowerText = text.toLowerCase();
        for(int i = 0; i < lowerText.length(); i++) {
            //.charAt(i) mengambil satu huruf/karakter pada posisi indeks ke-i
            //Lalu disimpan di variabel c
            char c = lowerText.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println("Jumlah huruf vokal: " + count);
    }
}

/*
1. Karena pada variabel text String yang dimasukkan mengandung spasi diawal bukan langsung huruf H
   sehingga Java akan langsung mengirim hasil false karena tidak sesuai. Hal ini dapat dibuktikan dengan
   menjalankan startsWith(" ") yang mengembalikan true.
2. String merupakan class yang bersifat immutable yang setiap perubahan pada data yang ada Java akan 
   membuat objek String baru sehingga jika perubahan dilakukan pada banyak data maka akan kurang efisien.
   StringBuilder adalah class yang bersifat mutable yang datanya dapat diubah pada objek yang sama
   sehingga memori yang digunakan hanya memori untuk membuat objek StringBuilder awal saja.
3. Dengan menggunakan indexOf("Java") untuk mencari dimana mulai kata Java dan kemudian dihitung panjang katanya
   dan dijumlah dengan hasil dari indexOf untuk mendapatkan hasil kapan kata berhenti dan kemudian kedua hasil tersebut
   dimasukkan ke dalam fungsi substring(start, end)
*/
