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
import java.io.*;


public class FileIOExample {
    public static void main(String[] args) {
        // Nama file sumber (input). Data mentah ditulis dan dibaca dari file ini.
        // Karena hanya berupa nama (tanpa path folder), file dibuat di folder tempat program dijalankan.
        String inputFile = "data.txt";
        // Nama file hasil proses. Berisi data yang sudah diubah formatnya.
        String outputFile = "output.txt";

        // Tulis data ke file
        // Langkah 1: membuat data.txt dan mengisinya dengan 4 data awal.
        // Jika data.txt sudah ada, isi lamanya akan dihapus dan diganti dengan data ini.
        writeToFile(inputFile);
        // Baca data dari file
        // Langkah 2: menampilkan isi data.txt (4 baris data di atas).
        readFromFile(inputFile);
        //Mencoba menambahkan data ke file data.txt yang sudah berisi
        // Langkah 3: menambahkan 1 data baru (Johannes) di bagian akhir data.txt.
        // Data lama tetap aman karena file dibuka dalam mode append (lihat writeToFileAdd).
        writeToFileAdd(inputFile);
        // Baca data dari file
        // Langkah 4: menampilkan isi data.txt lagi. Sekarang sudah ada 5 baris data.
        readFromFile(inputFile);
        // Process dan tulis ke file baru
        // Langkah 5: membaca data.txt, memproses setiap baris, lalu menulis hasilnya ke output.txt.
        processFile(inputFile, outputFile);
        // Baca data dari file
        // Langkah 6: menampilkan isi output.txt (baris pertama berisi header/judul kolom).
        readFromFile(outputFile);
        // Langkah 7: menghitung dan menampilkan rata-rata umur dari output.txt.
        // Hasilnya 24.8, yaitu total umur 124 dibagi 5 data.
        hitungRataRataUsia(outputFile);
    }

    /*
     Membuat file baru dengan nama yang diberikan, lalu menulis 4 baris data mahasiswa ke dalamnya.
     Jika file sudah ada, isi lamanya akan HILANG (ditimpa), karena FileWriter dibuka tanpa mode append.    
    */
    public static void writeToFile(String filename) {
        // try-with-resources: resource (BufferedWriter) dideklarasikan di dalam tanda kurung try.
        // Java akan otomatis memanggil writer.close() saat blok try selesai, baik berhasil maupun gagal.
        // Jadi file dijamin tertutup dan tidak ada kebocoran resource.
        //   - FileWriter(filename)  : membuka file untuk ditulis. Tanpa parameter tambahan, mode-nya overwrite.
        //   - BufferedWriter(...)   : membungkus FileWriter agar penulisan lebih efisien. Data dikumpulkan
        //                             dulu di memori (buffer) sebelum benar-benar ditulis ke disk.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // writer.write(...) menulis teks ke file, tetapi TIDAK otomatis pindah baris.
            // Karena itu setiap selesai menulis satu data, dipanggil writer.newLine() untuk
            // menulis karakter pindah baris. Karakternya mengikuti sistem operasi (\n di Linux/macOS, \r\n di Windows).
            writer.write("Alice, 25, Computer Science");
            writer.newLine();
            writer.write("Bob, 30, Mathematics");
            writer.newLine();
            writer.write("Charlie, 22, Physics");
            writer.newLine();
            writer.write("Diana, 28, Chemistry");
            writer.newLine();
            // Pesan ini hanya muncul di layar (console). Pesan ini tidak ditulis ke dalam file.
            System.out.println("Data berhasil ditulis ke " + filename);
        } catch (IOException e) {
            // Dijalankan jika terjadi error saat membuka atau menulis file,
            // misalnya folder tidak bisa diakses atau disk penuh.
            // e.getMessage() berisi keterangan singkat tentang error yang terjadi.
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }
    
    //Method yang dapat menambah data baru ke data lama
    /*
    Menambahkan 1 data baru di BAGIAN AKHIR file yang sudah ada, tanpa menghapus data lama.
    */
    public static void writeToFileAdd(String filename) {
        // Parameter kedua bernilai true pada FileWriter berarti mode APPEND (menambah di akhir file).
        // Jika parameter ini dihapus, file akan ditimpa seperti pada method writeToFile.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Menulis 1 baris data baru, lalu pindah baris agar data berikutnya tidak menempel di baris yang sama.
            writer.write("Johannes, 19, Software Engineering");
            writer.newLine();
            // "\n" di awal teks membuat pesan diawali baris kosong agar tampilan di layar lebih rapi.
            System.out.println("\nData berhasil ditambahkan ke " + filename);
        } catch (IOException e) {
            // Dijalankan jika file tidak bisa dibuka atau gagal ditulis.
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }

    /*
    Membaca isi file baris per baris, lalu menampilkan setiap baris ke layar beserta nomor barisnya.
    File tidak diubah sama sekali (hanya dibaca).
    */
    public static void readFromFile(String filename) {
        System.out.println("\n=== MEMBACA FILE ===");
        // FileReader membuka file untuk dibaca. BufferedReader membungkusnya agar pembacaan lebih efisien.
        // Seperti pada writer, try-with-resources akan menutup reader secara otomatis.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Variabel 'line' menyimpan satu baris teks yang sedang dibaca.
            String line;
            // Nomor baris, dimulai dari 1. Hanya dipakai untuk ditampilkan.
            int lineNumber = 1;
            // readLine() membaca satu baris dari file (tanpa karakter pindah baris di akhirnya).
            // Jika sudah sampai akhir file, readLine() mengembalikan null, dan perulangan berhenti.
            // Assignment (line = reader.readLine()) dilakukan di dalam kondisi while, lalu dicek null-nya.
            while ((line = reader.readLine()) != null) {
                // Tampilkan nomor baris dan isinya, misalnya "Line 1: Alice, 25, Computer Science".
                System.out.println("Line " + lineNumber + ": " + line);
                // Naikkan nomor baris untuk baris berikutnya.
                lineNumber++;
            }
            System.out.println("File berhasil dibaca");
        } catch (FileNotFoundException e) {
            // Dijalankan jika file tidak ditemukan.
            // Blok ini harus ditulis SEBELUM catch IOException, karena FileNotFoundException
            // adalah turunan (subclass) dari IOException. Lihat catatan nomor 2 di bagian bawah file.
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            // Dijalankan untuk error I/O lain yang bukan "file tidak ditemukan".
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Membaca data dari inputFile, memprosesnya, lalu menulis hasilnya ke outputFile.
     * Pemrosesan yang dilakukan:
     *   - Nama diubah menjadi huruf besar semua.
     *   - Kolom STATUS ditambahkan berdasarkan umur:
     *       umur > 25   -> "GRADUATE"
     *       umur <= 25  -> "UNDERGRADUATE"
     * Baris pertama outputFile berisi header: NAME, AGE, MAJOR, STATUS.
     *
     * @param inputFile  nama file sumber (data mentah), misalnya "data.txt"
     * @param outputFile nama file hasil proses, misalnya "output.txt"
     */
    public static void processFile(String inputFile, String outputFile) {
        System.out.println("\n=== MEMPROSES FILE ===");
        // Dua resource dibuka sekaligus dalam satu try-with-resources, dipisahkan dengan tanda titik koma:
        //   - reader : untuk membaca inputFile
        //   - writer : untuk menulis outputFile (mode overwrite, karena tidak ada parameter true)
        // Keduanya akan ditutup otomatis di akhir blok try.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            // Menulis baris judul (header) sebagai baris pertama file output.
            // Header ini membuat isi file mudah dibaca seperti tabel.
            writer.write("NAME, AGE, MAJOR, STATUS");
            writer.newLine();
            
            // Perulangan ini membaca inputFile baris demi baris sampai habis.
            while ((line = reader.readLine()) != null) {
                // Split data berdasarkan koma
                // split(",") memecah teks menjadi array (kumpulan teks) setiap kali menemukan koma.
                // Contoh: "Alice, 25, Computer Science" menjadi ["Alice", " 25", " Computer Science"].
                // Index 0 = nama, index 1 = umur, index 2 = jurusan.
                String[] data = line.split(",");
                // Index 0 = nama. trim() membuang spasi di depan/belakang, lalu toUpperCase() mengubah ke huruf besar.
                String name = data[0].trim().toUpperCase();
                // Index 1 = umur. trim() membuang spasi, lalu Integer.parseInt() mengubah teks menjadi bilangan int.
                // Jika isinya bukan angka (misalnya "abc"), Java melempar NumberFormatException.
                int age = Integer.parseInt(data[1].trim());
                // Index 2 = jurusan. Cukup dibersihkan dari spasi di depan/belakang.
                String major = data[2].trim();
                // Operator ternary: (kondisi) ? nilai_jika_benar : nilai_jika_salah
                // Jika umur lebih dari 25 maka status "GRADUATE", selain itu "UNDERGRADUATE".
                String status = (age > 25) ? "GRADUATE" : "UNDERGRADUATE";

                // Tulis data yang telah diproses
                // String.format membuat teks baru berdasarkan pola "%s, %d, %s, %s".
                // %s berarti diisi teks (String), %d berarti diisi bilangan bulat (int).
                // Urutan pengisian sesuai urutan argumen: name, age, major, status.
                String processedLine = String.format("%s, %d, %s, %s", name, age, major, status);
                writer.write(processedLine);
                writer.newLine();
                // Tampilkan juga baris hasil proses ke layar sebagai informasi.
                System.out.println("Processed: " + processedLine);
            }
            System.out.println("File berhasil diproses dan disimpan sebagai " + outputFile);
        } catch (IOException e) {
            // Dijalankan jika file input tidak ditemukan (FileNotFoundException juga termasuk di sini,
            // karena merupakan turunan IOException) atau jika gagal menulis file output.
            System.out.println("Error processing file: " + e.getMessage());
        } 
        //Exception Handling untuk NumberFormatException
        catch (NumberFormatException e) {
            System.out.println("\n[ERROR] [ERROR] Baris umur yang dimasukkan tidak valid!");
        }
    }
    
    public static void hitungRataRataUsia(String filename) {
        // try-with-resources untuk membuka file dan memastikan file otomatis tertutup.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // totalAge : jumlah seluruh umur yang sudah dibaca. Mulai dari 0.
            int totalAge = 0;
            // count    : banyaknya data umur yang valid. Nilai ini menjadi pembagi. Mulai dari 0.
            int count = 0;
            // firstLine: penanda apakah baris yang sedang dibaca adalah baris pertama (header).
            // Nilai awal true karena baris pertama pasti header.
            boolean firstLine = true;
            
            // Membaca file baris per baris sampai habis.
            while((line = reader.readLine()) != null) {
                // Lewati baris kosong (atau baris yang hanya berisi spasi) agar tidak dianggap sebagai data.
                // trim() membuang spasi, lalu isEmpty() mengecek apakah hasilnya kosong.
                // continue berarti langsung lanjut ke putaran berikutnya tanpa menjalankan kode di bawahnya.
                if(line.trim().isEmpty()) {
                    continue;
                }
                
                // Lewati baris pertama (header: "NAME, AGE, MAJOR, STATUS") karena bukan data.
                // Setelah itu firstLine diubah menjadi false, sehingga baris berikutnya diproses sebagai data.
                // Catatan: baris kosong di atas dilewati dulu, jadi header selalu dicek pada baris tidak kosong pertama.
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                // Pisahkan baris berdasarkan koma, sama seperti pada processFile.
                // Index 1 berisi umur.
                String[] data = line.split(",");
                // Pastikan baris memiliki minimal 2 kolom, supaya data[1] pasti ada.
                if(data.length >= 2) {
                    // Blok try khusus untuk satu baris data. Jika umur pada baris ini tidak valid,
                    // error hanya dicatat dan perhitungan tetap dilanjutkan ke baris berikutnya.
                    try {
                        // Ambil umur dari index 1, ubah menjadi int, lalu tambahkan ke total.
                        int age = Integer.parseInt(data[1].trim());
                        totalAge += age;
                        // Tambah jumlah data valid sebanyak 1.
                        count++;
                    } catch (NumberFormatException e) {
                        // Umur bukan angka. Baris ini tidak dihitung, baik ke total maupun ke jumlah data.
                        System.out.println("\n[ERROR] [ERROR] Baris umur yang dimasukkan tidak valid!");
                    }
                }
            }
            // Rata-rata hanya dihitung jika ada minimal 1 data valid.
            // Pengecekan ini mencegah pembagian dengan nol (count = 0).
            if (count > 0) {
                // (double) totalAge mengubah totalAge menjadi tipe double SEBELUM dibagi.
                // Jika tidak diubah, pembagian antar-int akan membuang bagian desimal.
                // Contoh: 124 / 5 menghasilkan 24, bukan 24.8.
                double avgAge = (double) totalAge / count;
                // Tampilkan hasil rata-rata. Contoh hasil untuk output.txt: 24.8
                System.out.println("Rata - rata usia: " + avgAge);
            }
        } catch (IOException e) {
            // Dijalankan jika file tidak bisa dibaca, misalnya belum dibuat atau tidak ditemukan.
            System.out.println("Error membaca rata - rata usia.");
        }
    }
    
    
}

/*
1. Ketika kita menggunakan try - with - resource maka pada kode program tidak perlu khawatir untuk
   terus memastikan method .close() dipanggil di akhir blok program, meskipun terjadi exception
   sehingga mencegah kebocoran memori.
2. Karena FIleNotFoundException merupakan subclass dari IOException sehingga menanganinya secara terpisah
   memungkinkan kita untuk memberikan pesan error yang lebih spesifik daripada hanya menggunakan IOException.
   Dengan penulisan yang spesifik lebih dulu baru yang lebih tidak spesifik (FIleNotFoundException baru IOException).
3. Maka pada saat new FIleWriter(filename) isi dari data.txt yang sudah ada akan di overwrite dengan data yang baru.
   Dan jika ingin menambahkan data baru ke dalam data.txt yang sudah ada isinya menggunakan new FileWriter(filename, true).
*/
