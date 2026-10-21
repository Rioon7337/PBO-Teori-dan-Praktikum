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
public class CaughtExceptionFinallyModifikasi {
    public static void main(String args[]) {
        int n = args.length;
        //int n = 1;
         try {
            if (n == 0) {
                System.out.println(3/n);
                System.out.println("This won't be executed");
            } else {
                System.out.println("This will be executed if " 
                        + "arguments is not zero");
            }
        } catch (NullPointerException e) {
            System.out.println("Catching exception: " + e);
        } finally {
            System.out.println("After trying or catching...");
        }
    }
}

/*
1. Hasil yang terjadi adalah finally akan tetap dijalankan meski hasil dari try dan catch 
error atau tidak, sedangkan pada blok catch error tidak dapat di tangkap karena kondisi yang 
digunakan berbeda dimana error akan ditangkap apabila error NullPointerException namun error
yang ada merupakan bagian dari ArithmeticException.
*/
