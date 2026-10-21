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
public class MultipleCatch {
  public static void main(String args[]) {
        int n = args.length;
        int a = 1;
        int c[] = new int[1];
         try {
            if (a == 0) {
                a = a / (a - 1);
            } else {
                c[21] = 5;
            }
        } catch (ArithmeticException e) {
            System.out.println("Ups, seem out we have an Arithmetic " 
                    + "Exception here...");
        } catch (Exception e) {
            System.out.println("Let the other exception handler here...");
        }
    }  
}

/*
1. Pada program diatas catch statement yang ditangkap adalah ArithmeticException.
2. Apabila menggunakan arguments maka catch statement yang ditangkap adalah Exception.
3. Apabila posisi Exception ditukar maka akan terjadi compile time error karena pada
struktur try-catch catch yang dibaut pertama kali catch yang lebih spesifik atau setara dengan catch setelahnya.
*/