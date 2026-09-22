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

public class GanjilGenap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Silahkan masukkan bilangan: ");
        int a = input.nextInt();
        if(a % 2 == 0) {
            System.out.println(a + " adalah bilangan genap.");
        } else {
            System.out.println(a + " adalah bilangan ganjil.");
        }
    }
}
