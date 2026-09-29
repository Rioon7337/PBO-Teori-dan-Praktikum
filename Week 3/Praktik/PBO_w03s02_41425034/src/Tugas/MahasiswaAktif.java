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

public class MahasiswaAktif extends Mahasiswa {
    String semester;
    
    public void belajar() {
        System.out.println(" ");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println(nama + " sedang belajar di semester " + semester);
    }
}
