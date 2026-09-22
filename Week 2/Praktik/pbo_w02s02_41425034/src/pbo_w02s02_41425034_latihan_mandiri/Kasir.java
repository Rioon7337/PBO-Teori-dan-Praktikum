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

public class Kasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan nama barang: ");
        String a = input.nextLine();
        System.out.println("Masukkan harga barang: ");
        int b = input.nextInt();
        System.out.println("Masukkan jumlah beli: ");
        int c = input.nextInt();
        
        double d = b * c;
        System.out.println("Total harga sebelum diskon: " + d);
        if(d >= 100000) {
            double e = d / 10;
            System.out.println("Diskon: " + e);
        System.out.println("Total Bayar: " + (d - e));
            
        } else {
            double e = 0;
            System.out.println("Diskon: " + e);
        System.out.println("Total Bayar: " + (d - e));
        }
        
        
    }
}
