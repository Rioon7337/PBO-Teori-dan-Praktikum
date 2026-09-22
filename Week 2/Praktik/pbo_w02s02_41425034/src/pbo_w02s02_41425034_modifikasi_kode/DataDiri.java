/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_w02s02_41425034_modifikasi_kode;

import java.util.Scanner;
/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
public class DataDiri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Data");
        System.out.println("Nama anda: "); 
        String nama = input.nextLine();
        System.out.println("Umur anda: "); 
        int umur = input.nextInt();
        System.out.println("Tinggi anda: "); 
        double tinggi = input.nextDouble();
        System.out.println("Status mahasiswa anda: "); 
        boolean isMahasiswa = input.nextBoolean();
        
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + " tahun");
        System.out.println("Tinggi: " + tinggi + " cm");
        System.out.println("Status Mahasiswa: " + isMahasiswa);
        
        int tinggiBulat = (int) tinggi;
        System.out.println("Tinggi (dibulatkan): " + tinggiBulat + " cm");
    }
}
