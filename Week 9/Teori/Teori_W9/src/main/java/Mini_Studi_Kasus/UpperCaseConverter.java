/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mini_Studi_Kasus;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.util.*;

public class UpperCaseConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Silahkan masukkan nama file yang mau kamu buat: ");
        String namaFile = input.nextLine();
        writeToFileInput(namaFile + ".txt");
        
        
        writeToFile("input.txt");
        
        // Membuka BufferedReader untuk membaca dan BufferedWriter untuk menulis
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            
            String line;
            // Membaca teks baris demi baris sampai variabel line bernilai null (akhir file)
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase()); // Mengubah teks ke huruf kapital lalu menulisnya
                bw.newLine();                 // Membawa kursor ke baris baru di file output
                bw.write("Ini percobaan .newLine()");
                bw.write("Apa hasilnya ya??");
            }
            System.out.println("Konversi selesai! Hasil tersimpan di output.txt");
        } catch (IOException e) {
            System.out.println("Terjadi error I/O: " + e.getMessage());
        }
        
        readFromFile("output.txt");
        
        writeToFileAdd("input.txt");
        
        readFromFile("input.txt");
        
        readFromFile(namaFile + ".txt");
        
        writeToFileInputAdd(namaFile + ".txt");
        
        readFromFile(namaFile + ".txt");
    }
    
    public static void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Halo, perkenalkan namaku Rein");
            writer.newLine();
            System.out.println("Data berhasil ditulis ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }
    
        public static void readFromFile(String filename) {
        System.out.println("\n=== MEMBACA FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Variabel 'line' menyimpan satu baris teks yang sedang dibaca.
            String line;
            // Nomor baris, dimulai dari 1. Hanya dipakai untuk ditampilkan.
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                // Tampilkan nomor baris dan isinya, misalnya "Line 1: Alice, 25, Computer Science".
                System.out.println(line);
                // Naikkan nomor baris untuk baris berikutnya.
                lineNumber++;
            }
            System.out.println("File berhasil dibaca");
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            // Dijalankan untuk error I/O lain yang bukan "file tidak ditemukan".
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
        
    public static void writeToFileAdd(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Aku suka makanan manis.");
            writer.newLine();
            System.out.println("Data berhasil ditambahkan ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }
    
    public static void writeToFileInput(String filename) {
        Scanner input = new Scanner(System.in);
        System.out.println("Silahkan masukkan isi file yang mau kamu buat: ");
        String isiFile = input.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(isiFile);
            writer.newLine();
            System.out.println("Data berhasil ditulis ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }
    
    public static void writeToFileInputAdd(String filename) {
        Scanner input = new Scanner(System.in);
        System.out.println("Silahkan masukkan isi file yang mau kamu buat: ");
        String isiFile = input.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(isiFile);
            writer.newLine();
            System.out.println("Data berhasil ditambahkan ke " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        } 
    }
}

