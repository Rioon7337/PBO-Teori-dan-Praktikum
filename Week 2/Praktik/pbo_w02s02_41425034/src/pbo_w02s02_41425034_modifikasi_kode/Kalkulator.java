/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pbo_w02s02_41425034_modifikasi_kode;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
import java.util.Scanner;

public class Kalkulator {
    public static int pangkat(int a, int b){
        int hasil = 1;
        for (int i = 0; i < b; i++) {
            hasil *= a;
        }
        
        return hasil;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan angka pertama: ");
        int a = input.nextInt();
        System.out.println("Masukkan angka kedua: ");
        int b = input.nextInt();
        
        System.out.println("Tambah: " + (a + b));
        System.out.println("Kurang: " + (a - b));
        System.out.println("Kali: " + (a * b));
        System.out.println("Bagi: " + (double)a / b);
        System.out.println("Modulus: " + a % b);
        System.out.println("Pangkat: " + pangkat(a, b));
    }
    
}
/*
1. Nilai asli double memiliki alokasi memori yang lebih besar dari pada int,
selain itu double menyimpan angka secara desimal sedangkan jika double di casting 
menjadi int maka angka yang berada di belakang koma akan dihiraukan.
2. Karena hasil pembagian antar angka bervariabel int dapat menghasilkan angka desimal
apabila kedua angka jika dibagikan tidak tepat habis 0.
3. Hasil yang diberikan akan berupa String yang menuliskan infinity.
*/
