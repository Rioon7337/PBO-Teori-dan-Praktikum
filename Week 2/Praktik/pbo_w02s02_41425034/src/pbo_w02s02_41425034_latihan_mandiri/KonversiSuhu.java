/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_w02s02_41425034_latihan_mandiri;

import java.util.Scanner;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

public class KonversiSuhu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan suhu dalam Celcius: ");
        double a = input.nextInt();
        double CtoF = (double)(a * 9 / 5  + 32);
        System.out.println(a + " C = " + CtoF + " F");
        System.out.println("Masukkan suhu dalam Fahrenheit: ");
        double b = input.nextInt();
        double FtoC = (double)(b - 32) * 5 / 9;
        System.out.println(b + " F = " + FtoC + " C");
    }
}
