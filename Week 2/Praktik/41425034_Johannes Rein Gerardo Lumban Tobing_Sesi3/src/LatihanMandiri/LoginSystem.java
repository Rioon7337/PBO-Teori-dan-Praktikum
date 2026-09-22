/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanMandiri;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Data akun yang benar
        String usernameBenar = "admin";
        String passwordBenar = "password123";
        
        int maksimalPercobaan = 3;
        
        System.out.println("=== Sistem Login ===");
        
        // Looping untuk maksimal 3 kali percobaan
        for (int i = 1; i <= maksimalPercobaan; i++) {
            System.out.println("Percobaan " + i + ":");
            
            System.out.print("Username: ");
            String username = input.nextLine();
            
            System.out.print("Password: ");
            String password = input.nextLine();
            
            // 1. Cek apakah login berhasil
            if (username.equals(usernameBenar) && password.equals(passwordBenar)) {
                System.out.println("Login berhasil!");
                break; // Keluar dari loop jika berhasil
            }
            
            // 2. Cek apakah ini percobaan terakhir (ke-3)
            if (i == maksimalPercobaan) {
                System.out.println("Akun terkunci! Terlalu banyak percobaan gagal.");
                break; // Menghentikan program
            }
            
            // 3. Validasi aturan input jika login gagal
            // Mengecek apakah password kurang dari 8 karakter ATAU tidak mengandung angka (digit)
            boolean mengandungAngka = password.matches(".*\\d.*");
            
            if (password.length() < 8 || !mengandungAngka) {
                System.out.println("Login gagal! Password harus minimal 8 karakter dan mengandung angka.");
            } else if (username.length() < 5 || username.length() > 10) {
                System.out.println("Login gagal! Username harus antara 5-10 karakter.");
            } else {
                // Jika format sudah memenuhi syarat tapi tetap salah (misal: "wrongpass" atau lainnya)
                System.out.println("Login gagal! Password salah.");
            }
        }
        
        input.close();
    }
}
