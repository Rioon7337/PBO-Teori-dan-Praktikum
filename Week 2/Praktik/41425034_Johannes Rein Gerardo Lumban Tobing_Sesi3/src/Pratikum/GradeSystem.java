/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pratikum;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
import java.util.Scanner;

public class GradeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[5];
        double total = 0;
        
        //input nilai
        for(int  i = 0; i < 5; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }
        
        //hitung rata-rata
        double average = total / 5;
        System.out.println("Rata - rata nilai: " + average);
        
        //kategorikan nilai
        char grade;
        if(average >= 85) grade = 'A';
        else if(average >= 70) grade = 'B';
        else if(average >= 60) grade = 'C';
        else if(average >= 50) grade = 'D';
        else grade = 'E';
        
        System.out.println("Grade: " + grade);
        
        //tampilkan nilai tertinggi 
        double max = grades[0];
        double min = grades[0];
        
        for(int i = 0; i < 5; i++) {
            if(grades[i] > max) max = grades[i];
            if(grades[i] < min) min = grades[i];
        }
        
        System.out.println("Nilai tertinggi: " + max);
        System.out.println("Nilai terendah: " + min);
    }
    
}

/*
1. jika program menerima nilai diluar 0 - 100 program akan tetap menerima
input tersebut dan menghitung nilai diluar rentang tersebut.
2. Untuk menangani jumlah nilai yanng dinamis maka digunakan input user yang menentukan
jumlah pasti banyak nilai baru array tersebut dibuat berdasrakn banyak nilai yang diinput 
oleh pengguna.
*/