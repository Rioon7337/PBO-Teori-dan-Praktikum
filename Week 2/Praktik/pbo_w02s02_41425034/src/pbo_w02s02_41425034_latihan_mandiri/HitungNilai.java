/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_w02s02_41425034_latihan_mandiri;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

import java.util.Scanner;

public class HitungNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan nilai 1: ");
        int a = input.nextInt();
        System.out.println("Masukkan nilai 2: ");
        int b = input.nextInt();
        System.out.println("Masukkan nilai 3: ");
        int c = input.nextInt();
        
        System.out.println("Rata-rata: " + (double)(a + b + c)/3);
    }
}
