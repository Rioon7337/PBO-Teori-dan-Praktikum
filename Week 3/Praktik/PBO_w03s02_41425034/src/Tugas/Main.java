/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/

public class Main {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa();
        m1.nama = "Budi";
        m1.nim = "12345";
        
        System.out.println("Nama: " + m1.nama);
        System.out.println("NIM: " + m1.nim);
        
        MahasiswaAktif m2 = new MahasiswaAktif();
        m2.nama = "Dina";
        m2.nim = "123456";
        m2.semester = "5";
        m2.belajar();
    }
}
