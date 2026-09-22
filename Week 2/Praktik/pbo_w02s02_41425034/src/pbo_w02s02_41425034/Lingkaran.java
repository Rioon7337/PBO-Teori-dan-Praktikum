/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_w02s02_41425034;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
import java.util.Scanner;

public class Lingkaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double PI = 3.14;
        
        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();
        
        if (r < 0 ){
            System.out.println("Error: jari-jari tidak boleh negatif.");
        }
        else {
            double luas = PI * r * r;
            double keliling = 2 * PI * r;
            System.out.println("Luas: " + luas);
            System.out.println("Keliling: " + keliling);
        }
    }
}

/*
1. Karena dalam bangun datar tidak ada bilangan negatif sehingga jika tidak ada
validasi tersebut maka program akan dinyatakan gagal
2. Setelah dilakukan penginputan oleh user
*/