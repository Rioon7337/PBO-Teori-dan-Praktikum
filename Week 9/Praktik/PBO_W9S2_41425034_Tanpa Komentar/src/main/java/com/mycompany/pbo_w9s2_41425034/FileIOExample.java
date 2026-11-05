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
        String inputFile = "data.txt";
        String outputFile = "output.txt";

        // Tulis data ke file
        writeToFile(inputFile);
        // Baca data dari file
        readFromFile(inputFile);
        //Mencoba menambahkan data ke file data.txt yang sudah berisi
        writeToFileAdd(inputFile);
        // Baca data dari file
        readFromFile(inputFile);
        // Process dan tulis ke file baru
        processFile(inputFile, outputFile);
        // Baca data dari file
        readFromFile(outputFile);
        hitungRataRataUsia(outputFile);
    }

    public static void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Alice, 25, Computer Science");
            writer.newLine();
            writer.write("Bob, 30, Mathematics");
            writer.newLine();
            writer.write("Charlie, 22, Physics");
            writer.newLine();
            writer.write("Diana, 28, Chemistry");
            writer.newLine();
            System.out.println("Data berhasil ditulis ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }
    
    //Method yang dapat menambah data baru ke data lama
    public static void writeToFileAdd(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Johannes, 19, Software Engineering");
            writer.newLine();
            System.out.println("\nData berhasil ditambahkan ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }

    public static void readFromFile(String filename) {
        System.out.println("\n=== MEMBACA FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
            System.out.println("File berhasil dibaca");
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void processFile(String inputFile, String outputFile) {
        System.out.println("\n=== MEMPROSES FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            writer.write("NAME, AGE, MAJOR, STATUS");
            writer.newLine();
            
            while ((line = reader.readLine()) != null) {
                // Split data berdasarkan koma
                String[] data = line.split(",");
                String name = data[0].trim().toUpperCase();
                int age = Integer.parseInt(data[1].trim());
                String major = data[2].trim();
                String status = (age > 25) ? "GRADUATE" : "UNDERGRADUATE";

                // Tulis data yang telah diproses
                String processedLine = String.format("%s, %d, %s, %s", name, age, major, status);
                writer.write(processedLine);
                writer.newLine();
                System.out.println("Processed: " + processedLine);
            }
            System.out.println("File berhasil diproses dan disimpan sebagai " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        } 
        //Exception Handling untuk NumberFormatException
        catch (NumberFormatException e) {
            System.out.println("\n[ERROR] [ERROR] Baris umur yang dimasukkan tidak valid!");
        }
    }
    
    public static void hitungRataRataUsia(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int totalAge = 0;
            int count = 0;
            boolean firstLine = true;
            
            while((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) {
                    continue;
                }
                
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if(data.length >= 2) {
                    try {
                        int age = Integer.parseInt(data[1].trim());
                        totalAge += age;
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("\n[ERROR] [ERROR] Baris umur yang dimasukkan tidak valid!");
                    }
                }
            }
            if (count > 0) {
                double avgAge = (double) totalAge / count;
                System.out.println("Rata - rata usia: " + avgAge);
            }
        } catch (IOException e) {
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
