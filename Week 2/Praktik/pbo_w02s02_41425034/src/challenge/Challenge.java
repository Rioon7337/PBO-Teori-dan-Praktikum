/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package challenge;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan kata: ");
        String kata = input.nextLine().toLowerCase().replace(" ", "");
        
        String reverse = new StringBuilder(kata).reverse().toString();
        System.out.println(kata.equals(reverse) ? kata + " adalah palindrome" : kata + " bukan palindrome");
        
        int vokal = 0;
        for (char c : kata.toCharArray()) {
            if ("aiueo".indexOf(c) != -1) {
                vokal++;
            }
        }
        System.out.println("Jumlah huruf vokal: " + vokal);
    }
}
