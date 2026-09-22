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
public class SisaPangkat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan nilai 1: ");
        int a = input.nextInt();
        System.out.println("Masukkan nilai 2: ");
        int b = input.nextInt();
        
        double HasilSisa = a % b;
        double HasilPangkat = Math.pow(a, b);
        
        System.out.println("Sisa bagi: " + HasilSisa);
        System.out.println("Pangkat: " + HasilPangkat);
    }
}
