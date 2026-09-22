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

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = "admin";
        String password = "pass123";
        System.out.println("Masukkan username: ");
        String iUsername = input.nextLine();
        System.out.println("Masukkan password: ");
        String iPassword = input.nextLine();
        if (username == iUsername && password == iPassword) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal! Password tidak valid");
        }
    }
}
