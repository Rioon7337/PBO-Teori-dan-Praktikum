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

import java.io.*;
import java.util.*;

public class TextProcessor {
    public static void main(String[] args) {
        // Nama-nama file yang digunakan. Semua file dibuat di folder tempat program dijalankan.
        String sourceFile = "source.txt";
        String processedFile = "processed.txt";
        String reportFile = "report.txt";
        String csvFile = "data_nilai.csv";
        String csvSummaryFile = "Summary_statistics.txt";

        // Buat File sumber contoh
        // Langkah 1: membuat source.txt yang berisi 5 kalimat sebagai bahan olahan.
        createSampleFile(sourceFile);
        // Process file: uppercase + statistics
        // Langkah 2: memproses source.txt. Hasilnya processed.txt (huruf besar) dan report.txt (statistik).
        processTextFile(sourceFile, processedFile, reportFile);
        // Tampilkan report
        // Langkah 3: menampilkan isi report.txt ke layar.
        displayReport(reportFile);
        
        //Membuat file CSV sample
        createSampleCSV(csvFile);
        
        //Memproses CSV dan menghasilkan summary statistics
        processCSVStatistics(csvFile, csvSummaryFile);
        
        //Menampilkan laporan CSV summary
        displayReport(csvSummaryFile);
    }

    public static void createSampleFile(String filename) {
        // Array String (kumpulan teks) yang berisi 5 kalimat contoh.
        // Setiap elemen array akan ditulis sebagai satu baris di dalam file.
        String[] sampleText = {
            "Java programming is fun and powerful.",
            "Streams and Files are important concepts.",
            "Exception handling makes code robust.",
            "String manipulation is frequently used.",
            "Practice makes perfect in programming."
        };

        // try-with-resources: membuka BufferedWriter ke file dan menutupnya otomatis setelah selesai.
        // FileWriter(filename) tanpa parameter true berarti file dibuat baru atau ditimpa jika sudah ada.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Perulangan for-each: variabel line berisi satu kalimat pada setiap putaran.
            for (String line : sampleText) {
                // Tulis kalimat, lalu pindah baris agar setiap kalimat berada di baris sendiri.
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Sample file created: " + filename);
        } catch (IOException e) {
            // Dijalankan jika file gagal dibuat atau ditulis, misalnya karena tidak punya izin menulis di folder tersebut.
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    /*
    Method inti pemrosesan teks. Dalam SATU kali membaca file, method ini melakukan tiga pekerjaan:
    a. Menulis setiap baris dalam bentuk HURUF BESAR ke outputFile.
    b. Mengumpulkan statistik: jumlah baris, jumlah kata, dan jumlah karakter.
    c. Menghitung frekuensi setiap huruf (a sampai z, tanpa membedakan huruf besar dan kecil),
       lalu menuliskan laporan ke reportFile. Huruf diurutkan dari yang paling sering muncul.
    */
    public static void processTextFile(String inputFile, String outputFile, String reportFile) {
        // Tiga resource dibuka sekaligus di dalam try-with-resources:
        //   - reader       : membaca inputFile (sumber)
        //   - writer       : menulis outputFile (hasil huruf besar)
        //   - reportWriter : menulis reportFile (laporan statistik)
        // Ketiganya ditutup otomatis saat blok try selesai, baik berhasil maupun gagal.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile))) {
            
            // Variabel untuk menyimpan statistik. Semuanya dimulai dari 0.
            String line;
            // totalLines : jumlah baris yang sudah dibaca.
            int totalLines = 0;
            // totalWords : jumlah kata dari seluruh file.
            int totalWords = 0;
            // totalChars : jumlah karakter dari seluruh file (termasuk spasi dan tanda baca).
            int totalChars = 0;
            //variabel yang akan digunakan untuk menghitung jumlah kalimat
            int totalSentences = 0;
            // charFrequency: Map (semacam kamus) yang menyimpan pasangan huruf -> jumlah kemunculannya.
            // HashMap adalah salah satu implementasi Map. Tanda <Character, Integer> berarti
            // key bertipe char (dibungkus menjadi Character) dan value bertipe int (dibungkus menjadi Integer).
            Map<Character, Integer> charFrequency = new HashMap<>();
            //Map yang akan digunakan untuk menghitung jumlah frequency kata yang muncul
            Map<String, Integer> wordFrequency = new HashMap<>();

            // Membaca inputFile baris demi baris sampai habis (readLine mengembalikan null di akhir file).
            while ((line = reader.readLine()) != null) {
                // Setiap kali satu baris berhasil dibaca, tambah penghitung baris.
                totalLines++;
                // Process Line: convert to uppercase
                // toUpperCase() mengubah seluruh huruf pada baris menjadi huruf besar.
                // Variabel line sendiri tidak berubah. Hasilnya disimpan di variabel baru, processedLine.
                String processedLine = line.toUpperCase();
                // Tulis baris yang sudah huruf besar ke outputFile, lalu pindah baris.
                writer.write(processedLine);
                writer.newLine();
                
                //Loop yang akan digunakan untuk menghitung banyak kalimat berdasarkan tanda titik
                for(int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == '.') {
                        totalSentences++;
                    }
                }

                // Calculate statistics
                // Pecah baris menjadi kata-kata. Pola "\\s+" berarti satu atau lebih karakter spasi
                // (spasi biasa, tab, atau baris baru) sebagai pemisah. Lihat catatan nomor 2 di bagian bawah file.
                // Hasilnya array String. Panjang array = jumlah kata pada baris ini.
                String[] words = line.split("\\s+");
                // Tambahkan jumlah kata baris ini ke total kata seluruh file.
                totalWords += words.length;
                // length() menghitung jumlah karakter pada baris (termasuk spasi dan tanda baca),
                // lalu hasilnya ditambahkan ke total karakter.
                totalChars += line.length();
                
                //Loop yang akan digunakan untuk menghitung frequency kemunculan kata
                for(String w : words) {
                    //menghilangkan semua karakter yang bukan huruf dan mengubahnya menjadi huruf kecil semua
                    String justWord = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if(!justWord.isEmpty()) {
                        wordFrequency.put(justWord, wordFrequency.getOrDefault(justWord, 0) + 1);
                    }
                }

                // Character frequency
                // toLowerCase() membuat semua huruf menjadi kecil, supaya 'A' dan 'a' dihitung sebagai huruf yang sama.
                // toCharArray() mengubah String menjadi array of char, yaitu kumpulan karakter satu per satu.
                // Pada perulangan for-each ini, variabel c berisi satu karakter pada setiap putaran.
                for (char c : line.toLowerCase().toCharArray()) {
                    // Character.isLetter(c) mengecek apakah c adalah sebuah huruf.
                    // Spasi, angka, dan tanda baca dilewati, sehingga tidak masuk perhitungan frekuensi.
                    if (Character.isLetter(c)) {
                        // getOrDefault(c, 0) mengambil jumlah kemunculan huruf c saat ini.
                        // Jika c belum pernah ditemukan, nilai yang diambil adalah 0.
                        // Nilai itu ditambah 1, lalu disimpan kembali dengan put(...).
                        charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                    }
                }
            }
            
            //Mencari kata yang paling sering muncul
            String mostFrequentWord = "-";
            int maxWordCount = 0;
            for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                if(entry.getValue() > maxWordCount) {
                    maxWordCount = entry.getValue();
                    mostFrequentWord = entry.getKey();
                }
            }

            // Write report
            // Setiap penulisan ke reportWriter diikuti newLine() agar setiap informasi berada di baris sendiri.
            // Judul laporan.
            reportWriter.write("=== TEXT PROCESSING REPORT ===");
            reportWriter.newLine();
            // Jumlah baris. Angka (int) digabung dengan teks menggunakan operator +.
            reportWriter.write("Total Lines: " + totalLines);
            reportWriter.newLine();
            reportWriter.write("Total Sentences: " + totalSentences);
            reportWriter.newLine();
            reportWriter.write("Total Words: " + totalWords);
            reportWriter.newLine();
            reportWriter.write("Total Characters: " + totalChars);
            reportWriter.newLine();
            // Rata-rata kata per baris = total kata dibagi total baris.
            // (double) totalWords mengubah totalWords menjadi double SEBELUM dibagi, sehingga hasilnya memiliki desimal.
            // Contoh: 27 / 5 menghasilkan 5.4. Jika tanpa (double), hasilnya 5.
            // Catatan: jika file kosong (totalLines = 0), hasilnya NaN (Not a Number). Pembagian double dengan nol
            // tidak menyebabkan exception, sehingga program tetap berjalan.
            reportWriter.write("Average Words per Line: " + (double) totalWords / totalLines);
            reportWriter.newLine();
            reportWriter.newLine();
            reportWriter.write("Kata yang paling sering muncul: " + mostFrequentWord + " - " + maxWordCount);
            reportWriter.newLine();
            // newLine() tanpa teks menghasilkan baris kosong sebagai pemisah sebelum bagian frekuensi huruf.
            reportWriter.newLine();
            reportWriter.write("CHARACTER FREQUENCY:");
            reportWriter.newLine();

            // Sort characters by frequency
            // Map tidak memiliki urutan yang tetap, sehingga isinya dipindahkan ke dalam List agar bisa diurutkan.
            // entrySet() menghasilkan kumpulan pasangan Map.Entry. Setiap Entry berisi satu key (huruf) dan value (jumlah).
            // new ArrayList<>(...) membuat List baru yang berisi semua pasangan tersebut.
            List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charFrequency.entrySet());
            // sort(...) mengurutkan List dengan aturan pembanding (comparator) berupa lambda expression:
            //   (a, b) -> b.getValue().compareTo(a.getValue())
            // a dan b adalah dua pasangan yang sedang dibandingkan. compareTo() mengembalikan angka negatif,
            // nol, atau positif. Karena yang dibandingkan adalah b terhadap a (urutannya dibalik),
            // hasil akhirnya menurun: frekuensi terbesar berada di posisi paling atas.
            sortedChars.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Menulis setiap huruf beserta frekuensinya ke laporan, misalnya "e: 16".
            for (Map.Entry<Character, Integer> entry : sortedChars) {
                // getKey() mengambil hurufnya, getValue() mengambil jumlah kemunculannya.
                // Operator + menggabungkan keduanya menjadi satu teks.
                reportWriter.write(entry.getKey() + ": " + entry.getValue());
                reportWriter.newLine();
            }

            // Menampilkan ringkasan proses ke layar (console) sebagai informasi.
            System.out.println("File processing completed!");
            System.out.println(" - Input: " + inputFile);
            System.out.println(" - Output: " + outputFile);
            System.out.println(" - Report: " + reportFile);
        } catch (IOException e) {
            // Dijalankan jika salah satu dari ketiga file gagal dibuka, dibaca, atau ditulis.
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    public static void displayReport(String reportFile) {
        System.out.println("\n=== PROCESSING REPORT ===");
        // Membuka file laporan untuk dibaca. try-with-resources menutup file secara otomatis.
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            // Membaca setiap baris laporan dan langsung menampilkannya ke layar.
            // Perulangan berhenti ketika readLine() mengembalikan null, yaitu sudah sampai akhir file.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Dijalankan jika file laporan tidak bisa dibaca, misalnya belum dibuat atau tidak ditemukan.
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
    
    public static void createSampleCSV(String fileName) {
        String[] csvData = {
            "Nama, NIM, Nilai_PBO, Nilai_Basis_Data",
            "Sari, 13, 89, 90",
            "Budi, 14, 91, 78",
            "Rina, 30, 70, 66",
            "Johannes, 34, 75, 75"
        };
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : csvData) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("CSV File created " + fileName);
        } catch(IOException e) {
            System.out.println("Error creating CSV File: " + e.getMessage());
        }
    }
    
    // Method untuk memproses file CSV dan menghasilkan summary statistics
    public static void processCSVStatistics(String inputFile, String reportFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {

            String line;
            int totalSiswa = 0;
            double totalNilaiPBO = 0;
            double totalNilaiBD = 0;
            double maxPBO = Double.MIN_VALUE;
            double minPBO = Double.MAX_VALUE;
            String mahasiswaMaxPBO = "";
            String mahasiswaMinPBO = "";

            boolean isHeader = true;

            // Membaca baris CSV satu per satu
            while ((line = reader.readLine()) != null) {
                // Lewati baris header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Memecah kolom berdasarkan tanda koma (,)
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String nama = parts[0].trim();
                    try {
                        // Parsing data numerik dari string CSV
                        double nilaiPBO = Double.parseDouble(parts[2].trim());
                        double nilaiBD = Double.parseDouble(parts[3].trim());

                        totalSiswa++;
                        totalNilaiPBO += nilaiPBO;
                        totalNilaiBD += nilaiBD;

                        // Mencari nilai tertinggi & terendah PBO beserta nama mahasiswanya
                        if (nilaiPBO > maxPBO) {
                            maxPBO = nilaiPBO;
                            mahasiswaMaxPBO = nama;
                        }
                        if (nilaiPBO < minPBO) {
                            minPBO = nilaiPBO;
                            mahasiswaMinPBO = nama;
                        }

                    } catch (NumberFormatException e) {
                        // Penanganan error jika data angka pada CSV tidak valid
                        System.out.println("Peringatan: Format angka tidak valid pada baris CSV -> " + line);
                    }
                }
            }

            // Menghitung rata-rata kelas
            double avgPBO = (totalSiswa > 0) ? (totalNilaiPBO / totalSiswa) : 0;
            double avgBD = (totalSiswa > 0) ? (totalNilaiBD / totalSiswa) : 0;

            // Menulis laporan ringkasan statistik CSV ke file teks
            writer.write("=== SUMMARY STATISTICS REPORT (CSV) ===");
            writer.newLine();
            writer.write("Total Mahasiswa      : " + totalSiswa);
            writer.newLine();
            writer.newLine();
            writer.write("--- Statistik Nilai PBO ---");
            writer.newLine();
            writer.write("Rata-rata Nilai PBO  : " + String.format("%.2f", avgPBO));
            writer.newLine();
            writer.write("Nilai PBO Tertinggi  : " + maxPBO + " (" + mahasiswaMaxPBO + ")");
            writer.newLine();
            writer.write("Nilai PBO Terendah   : " + minPBO + " (" + mahasiswaMinPBO + ")");
            writer.newLine();
            writer.newLine();
            writer.write("--- Statistik Nilai Basis Data ---");
            writer.newLine();
            writer.write("Rata-rata Nilai BD   : " + String.format("%.2f", avgBD));
            writer.newLine();

            System.out.println("CSV Statistics processing completed!");

        } catch (IOException e) {
            System.out.println("Error processing CSV file: " + e.getMessage());
        }
    }
}

/*
1. HashMap bekerja dengan menggunakan key-value dimana key akan diisi dengan huruf (char) dan value
   akan berisi banyak huruf yang muncul(integer). Dan pada  loop for(char c : line.toLowerCase().toCharArray())
   tiap huruf akan dimasukkan ke dalam map dan jika huruf sudah ada maka nilainya akan ditambah 1.
   Catatan: urutan huruf yang memiliki frekuensi sama mengikuti urutan internal HashMap, sehingga tidak dijamin.
2. Karena \\s+ merupakan ekspresi yang dapat merepresentasikan lebih dari satu spasi, seperti spasi biasa, tab, dan juga baris baru.
   Sedangkan " " hanya akan merepresntasikan satu spasi biasa saja., sehingga penggunaan \\s+ lebih direkomendasikan
   untuk mencegah jika string memiliki lebih dari satu spasi.
3. BufferedReader/BufferedWriter menggunakan memori sementara untuk membaca/menulis data, sehingga mengurangi jumlah I/O yang masuk
   ke dalam penyimpanan komputer.
*/
