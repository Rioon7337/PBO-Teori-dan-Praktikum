package program1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
import java.util.*;

/*
1. Jika method overload dihapus maka akan terjadi error karena pada function main
dipanggil suatu method yang tidak pernah ada.
2. Disaat kita membuat method dengan dengan urutan parameter berbeda maka sistem akan 
berpikir bahwa method tersebut berbeda dari method ucapkan sebelumnya dengan parameter
sama, tetapi urutannya berbeda sehingga method tersebut dapat dijalankan.
*/

public class Mantra {
    //Method ucapkan() dengan satu parameter
    public void ucapkan(String namaMantra) {
        System.out.println("Mengucapkan mantra " + namaMantra);
    }
    
    //Overload: method ucapkan() dengan dua parameter
    public void ucapkan(String namaMantra, int kekuatan) {
        System.out.println("Mengucapkan mantra " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10) {
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: senjata terlepas!");
        }
    }
    
    public void ucapkan(int kekuatan, String namaMantra) {
        System.out.println("Mengucapkan mantra " + namaMantra + " dengan kekuatan " + kekuatan);
        if (kekuatan > 10) {
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: senjata terlepas!");
        }
    }
    
    //Overload: method ucapkan() dengan tiga parameter
    public void ucapkan(String namaMantra, int kekuatan, String target) {
        System.out.println("Mengucapkan mantra " + namaMantra + " dengan kekuatan " + kekuatan + " pada " + target);
        if (kekuatan > 10) {
            System.out.println("Efek: Lawan terlempar!");
        } else {
            System.out.println("Efek: senjata terlepas!");
        }
    }
    
    public static void main(String[] args) {
        Mantra mantra = new Mantra();
        mantra.ucapkan("Expelliarmus");
        mantra.ucapkan("Expelliarmus", 5);
        mantra.ucapkan("Expelliarmus", 15, "Voldemort");
        mantra.ucapkan(10, "Expelliarmus");
    }
}
