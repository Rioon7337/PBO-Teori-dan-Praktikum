/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbo_w7s02_41425034;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/
public class CaughtExceptionFinally {
    public static void main(String args[]) {
        //int n = args.length;
        int n = 1;
         try {
            if (n == 0) {
                System.out.println(3/n);
                System.out.println("This won't be executed");
            } else {
                System.out.println("This will be executed if " 
                        + "arguments is not zero");
            }
        } catch (Exception e) {
            System.out.println("Catching exception: " + e);
        } finally {
            System.out.println("After trying or catching...");
        }
    }
}

/*
1. Hasil eksekusi program berupa hasil catch dari ArithmeticException karena sistem
mencoba membagi 3 dengan 0 yang kemudian mengeksekusi finally.
2. Apabila kode dieksekusi dengan argumen contohnya n = 1, maka pada try percabangan
akan mengeksekusi else dan melewatkan catch langsung ke finally.
3. Dari beberapa kode yang sudah di eksekusi dapat disimpulkan bahwa finally akan selalu
di eksekusi tidak peduli hasil dari kode pada blok try menghasilkan error atau tidak.
*/
