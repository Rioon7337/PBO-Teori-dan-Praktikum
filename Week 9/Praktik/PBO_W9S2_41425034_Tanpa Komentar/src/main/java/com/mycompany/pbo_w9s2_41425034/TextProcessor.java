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
        String sourceFile = "source.txt";
        String processedFile = "processed.txt";
        String reportFile = "report.txt";

        // Buat File sumber contoh
        createSampleFile(sourceFile);
        // Process file: uppercase + statistics
        processTextFile(sourceFile, processedFile, reportFile);
        // Tampilkan report
        displayReport(reportFile);
    }

    public static void createSampleFile(String filename) {
        String[] sampleText = {
            "Java programming is fun and powerful.",
            "Streams and Files are important concepts.",
            "Exception handling makes code robust.",
            "String manipulation is frequently used.",
            "Practice makes perfect in programming."
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : sampleText) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Sample file created: " + filename);
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }

    public static void processTextFile(String inputFile, String outputFile, String reportFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
             BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile))) {
            
            String line;
            int totalLines = 0;
            int totalWords = 0;
            int totalChars = 0;
            Map<Character, Integer> charFrequency = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                totalLines++;
                // Process Line: convert to uppercase
                String processedLine = line.toUpperCase();
                writer.write(processedLine);
                writer.newLine();

                // Calculate statistics
                String[] words = line.split("\\s+");
                totalWords += words.length;
                totalChars += line.length();

                // Character frequency
                for (char c : line.toLowerCase().toCharArray()) {
                    if (Character.isLetter(c)) {
                        charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                    }
                }
            }

            // Write report
            reportWriter.write("=== TEXT PROCESSING REPORT ===");
            reportWriter.newLine();
            reportWriter.write("Total Lines: " + totalLines);
            reportWriter.newLine();
            reportWriter.write("Total Words: " + totalWords);
            reportWriter.newLine();
            reportWriter.write("Total Characters: " + totalChars);
            reportWriter.newLine();
            reportWriter.write("Average Words per Line: " + (double) totalWords / totalLines);
            reportWriter.newLine();
            reportWriter.newLine();
            reportWriter.write("CHARACTER FREQUENCY:");
            reportWriter.newLine();

            // Sort characters by frequency
            List<Map.Entry<Character, Integer>> sortedChars = new ArrayList<>(charFrequency.entrySet());
            sortedChars.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (Map.Entry<Character, Integer> entry : sortedChars) {
                reportWriter.write(entry.getKey() + ": " + entry.getValue());
                reportWriter.newLine();
            }

            System.out.println("File processing completed!");
            System.out.println(" - Input: " + inputFile);
            System.out.println(" - Output: " + outputFile);
            System.out.println(" - Report: " + reportFile);
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    public static void displayReport(String reportFile) {
        System.out.println("\n=== PROCESSING REPORT ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report: " + e.getMessage());
        }
    }
}

/*
1. HashMap bekerja dengan menggunakan key-value dimana key akan diisi dengan huruf (char) dan value
   akan berisi banyak huruf yang muncul(integer). Dan pada  loop for(char c : line.toLowerCase().toCharArray())
   tiap huruf akan dimasukkan ke dalam map dan jika huruf sudah ada maka nilainya akan ditambah 1.
2. Karena \\s+ merupakan ekspresi yang dapat merepresentasikan lebih dari satu spasi, seperti spasi biasa, tab, dan juga baris baru.
   Sedangkan " " hanya akan merepresntasikan satu spasi biasa saja., sehingga penggunaan \\s+ lebih direkomendasikan
   untuk mencegah jika string memiliki lebih dari satu spasi.
3. BufferedReader/BufferedWriter menggunakan memori sementara untuk membaca/menulis data, sehingga mengurangi jumlah I/O yang masuk
   ke dalam penyimpanan komputer.
*/
