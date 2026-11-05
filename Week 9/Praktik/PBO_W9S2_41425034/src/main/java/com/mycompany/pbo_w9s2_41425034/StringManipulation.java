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
        // Teks yang akan dimanipulasi. Perhatikan ada spasi di awal dan di akhir teks.
        // String bersifat immutable (tidak bisa diubah). Method seperti toUpperCase() atau replace()
        // tidak mengubah variabel text, melainkan mengembalikan String baru.
        String text = " Hello World! Welcome to Java Programming ";
        System.out.println("=== BASIC STRING OPERATIONS ===");
        //Percobaan startsWith
        // startsWith(...) mengecek apakah teks DIMULAI dengan teks yang diberikan. Hasilnya true atau false.
        // Karena teks diawali spasi (bukan huruf 'H'), hasilnya false.
        System.out.println(text.startsWith("Hello")); // hasil: false
        // Mengecek apakah teks diawali dengan spasi. Karena memang ada spasi di awal, hasilnya true.
        System.out.println(text.startsWith(" ")); //hasil: true
        // Menampilkan teks asli. Tanda kutip tunggal ' hanya dipakai untuk memperjelas batas awal dan akhir teks,
        // sehingga spasi di awal dan di akhir terlihat.
        System.out.println("Original: '" + text + "'");
        // length() menghitung jumlah karakter dalam teks. Spasi dan tanda seru (!) ikut dihitung.
        System.out.println("Length: " + text.length());
        //.trim() digunakan untuk menghapus spaasi di awal dan di akhir
        // trim() hanya membuang spasi di awal dan akhir teks. Spasi di tengah kata tidak ikut dihapus.
        System.out.println("Trimmed: '" + text.trim() + "'");
        // toUpperCase() mengubah semua huruf menjadi huruf besar. Karakter selain huruf (spasi, '!') tidak berubah.
        System.out.println("Uppercase: '" + text.toUpperCase() + "'");
        // toLowerCase() mengubah semua huruf menjadi huruf kecil.
        System.out.println("Lowercase: '" + text.toLowerCase() + "'");

        // Substring dan indexing
        // Bagian ini menjelaskan cara mengakses posisi (index) karakter dalam sebuah teks.
        // Index dimulai dari 0. Contoh: index 0 = spasi, index 1 = 'H', index 2 = 'e', index 3 = 'l', dan seterusnya.
        System.out.println("\n=== SUBSTRING & INDEXING ===");
        // charAt(5) mengambil satu karakter pada index ke-5. Hasilnya 'o' (huruf terakhir dari kata "Hello").
        System.out.println("Character at index 5: '" + text.charAt(5) + "'");
        // substring(7, 12) mengambil potongan teks mulai dari index 7 (termasuk) sampai index 12 (TIDAK termasuk).
        // Hasilnya "World", yaitu karakter pada index 7, 8, 9, 10, dan 11.
        System.out.println("Substring (7-12): '" + text.substring(7, 12) + "'");
        // indexOf("World") mengembalikan index pertama tempat kata "World" ditemukan. Hasilnya 7.
        // Jika kata tidak ditemukan, hasilnya -1.
        System.out.println("Index of 'World': " + text.indexOf("World"));
        // lastIndexOf("a") mencari kemunculan huruf 'a' yang paling akhir. Hasilnya 35,
        // yaitu posisi huruf 'a' pada kata "Programming".
        System.out.println("Last index of 'a': " + text.lastIndexOf("a"));

        // Replacement dan comparison
        // Bagian ini berisi method untuk mengganti teks dan membandingkan isi teks.
        System.out.println("\n=== REPLACEMENT & COMPARISON ===");
        // replace("Java", "Python") mengganti SEMUA kemunculan kata "Java" dengan "Python".
        // Teks asli tidak berubah. Hasilnya berupa String baru yang ditampilkan di layar.
        System.out.println("Replace 'Java' with 'Python': '" + text.replace("Java", "Python") + "'");
        // contains(...) mengecek apakah teks mengandung kata "Programming" di posisi mana pun. Hasilnya true.
        System.out.println("Contains 'Programming': " + text.contains("Programming"));
        // Mengecek awalan teks. Hasilnya false karena teks diawali spasi, sama seperti pada bagian awal.
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        // endsWith(...) mengecek akhiran teks. Hasilnya false, karena teks diakhiri SPASI,
        // bukan langsung oleh kata "Programming". Jika method ini dipanggil pada hasil trim(),
        // hasilnya menjadi true.
        System.out.println("Ends with 'Programming': " + text.endsWith("Programming"));

        // Split dan join
        // Bagian ini memecah teks menjadi beberapa kata, lalu menampilkannya satu per satu.
        System.out.println("\n=== SPLIT & JOIN ===");
        // trim() dipakai dulu untuk membuang spasi di awal dan akhir.
        // split(" ") memecah teks setiap kali menemukan satu spasi, dan hasilnya berupa array String (kumpulan kata).
        // Contoh: "Hello World!" menjadi ["Hello", "World!"].
        // Catatan: split(" ") hanya memisahkan dengan satu spasi. Pada bagian berikutnya dipakai split("\\s+"),
        // yang juga memisahkan dengan tab dan baris baru. Perbedaannya dijelaskan pada catatan di kelas TextProcessor.
        String[] words = text.trim().split(" ");
        // length pada array berisi jumlah elemennya, yaitu jumlah kata. Hasilnya 6.
        System.out.println("Number of words: " + words.length);
        System.out.print("Words: ");
        // Perulangan for-each: variabel word berisi satu kata pada setiap putaran, dari kata pertama sampai terakhir.
        for (String word : words) {
            // print (bukan println) menampilkan kata tanpa pindah baris. Kata diapit kurung siku sebagai pembatas.
            System.out.print("[" + word + "] ");
        }
        // println() tanpa isi hanya membuat baris baru setelah semua kata ditampilkan.
        System.out.println();

        // StringBuilder untuk efisiensi
        // StringBuilder bersifat mutable (bisa diubah). Perubahan dilakukan langsung pada objek yang sama,
        // sehingga lebih efisien daripada menggabungkan String berulang kali.
        System.out.println("\n=== STRING BUILDER ===");
        // Membuat StringBuilder kosong.
        StringBuilder sb = new StringBuilder();
        // append(...) menambahkan teks di BAGIAN AKHIR. Setelah baris ini isi sb adalah "Java".
        sb.append("Java");
        // Menambahkan " Programming" di akhir. Sekarang isi sb adalah "Java Programming".
        sb.append(" Programming");
        // insert(0, ...) menyisipkan teks pada index 0, yaitu di bagian awal. Sekarang isi sb adalah "Learn Java Programming".
        sb.insert(0, "Learn ");
        // reverse() membalik urutan seluruh karakter. "Learn Java Programming" menjadi "gnimmargorP avaJ nraeL".
        sb.reverse();
        // toString() mengubah StringBuilder kembali menjadi String biasa.
        System.out.println("Reversed: " + sb.toString());
        
        //Mengambil kata Java
        // Menyimpan kata yang dicari dalam variabel. Dengan begitu, jika ingin mencari kata lain,
        // cukup ubah nilai variabel ini.
        String kata = "Java";
        // indexOf(kata) mencari posisi awal kata "Java" di dalam text. Hasilnya 25.
        int start = text.indexOf(kata);
        // length() dari "Java" adalah 4 karakter. Nilai ini dipakai sebagai panjang potongan yang akan diambil.
        int end = kata.length(); 
        // Posisi akhir = posisi awal + panjang kata. Jadi substring(start, start + end) mengambil tepat
        // 4 karakter mulai dari posisi awal, yaitu "Java".
        System.out.println("Mengambil kata Java: " + text.substring(start, start + end));
        
        //Modifikasi
        //Hanya menampilkan kata lebih dari 4
        // Bagian ini hanya menampilkan kata yang panjangnya lebih dari 4 huruf.
        System.out.println("\n=== MENAMPILKAN LEBIH DARI 4 HURUF ===");
        //Mengubah isi variabel text menjadi array per kata
        // trim() membuang spasi di awal dan akhir. Lalu split("\\s+") memecah teks setiap kali
        // ada satu atau lebih karakter spasi (spasi biasa, tab, atau baris baru).
        // Di dalam string Java, "\\s+" ditulis dengan dua backslash. Pola yang sebenarnya adalah \s+.
        String[] kata4 = text.trim().split("\\s+");
        //loop untuk print setiap isi dari array kata4 dengan kondisi
        for(String word : kata4) {
            //menghilangkan semua karakter yang bukan huruf
            // replaceAll("[^a-zA-Z]", "") mengganti setiap karakter yang BUKAN huruf A sampai Z (besar maupun kecil)
            // dengan teks kosong. Tanda ^ di dalam kurung siku berarti "bukan".
            // Contoh: "World!" menjadi "World", dan "Hello," menjadi "Hello".
            String onlyWord = word.replaceAll("[^a-zA-Z]", "");
            // Hanya kata dengan panjang lebih dari 4 huruf yang ditampilkan.
            // Contoh: "to" (2 huruf) dan "Java" (4 huruf) tidak lolos, sedangkan "Hello" (5 huruf) lolos.
            if (onlyWord.length() > 4) {
                // Menggunakan print (bukan println), sehingga kata-kata tampil berderet dalam satu baris.
                System.out.print(onlyWord + " ");
            }
        }
        
        //Menghitung jumlah huruf vokal
        // Bagian ini menghitung berapa kali huruf vokal (a, e, i, o, u) muncul dalam teks.
        System.out.println("\n=== MENGHITUNG HURUF VOKAL ===");
        // Variabel penampung jumlah vokal. Mulai dari 0.
        int count = 0;
        //Membuat isi variabel text menjadi huruf kecil semua
        // Dengan semua huruf kecil, pengecekan cukup dilakukan untuk huruf kecil saja (tidak perlu versi kapital).
        String lowerText = text.toLowerCase();
        // Perulangan for klasik. Variabel i dimulai dari 0 dan berjalan sampai (panjang teks - 1),
        // sehingga setiap karakter dalam teks diperiksa satu per satu.
        for(int i = 0; i < lowerText.length(); i++) {
            //.charAt(i) mengambil satu huruf/karakter pada posisi indeks ke-i
            //Lalu disimpan di variabel c
            // char adalah tipe data untuk satu karakter. Nilainya ditulis dengan tanda kutip tunggal, misalnya 'a'.
            char c = lowerText.charAt(i);
            // || berarti ATAU. Kondisi ini bernilai true jika c sama dengan salah satu dari huruf vokal.
            // Karakter selain vokal (konsonan, spasi, tanda seru) diabaikan.
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                // Setiap vokal yang ditemukan menambah penghitung sebanyak 1.
                count++;
            }
        }
        // Menampilkan total huruf vokal. Hasilnya 12.
        // Huruf 'y' tidak termasuk dalam daftar vokal pada program ini.
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
