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
public class ReThrowExc {
    static void demoThrow() {
        try {
            System.out.println("I'm throwing an exception from demoThrow "
                                + "method");
            throw new NullPointerException("demo");
       } catch (NullPointerException e) {
           System.out.println("I'm catching the exception [" + e + "]");
           System.out.println("But I'll throw it again...\n");
           throw e;
       }
    }
    
    public static void main(String args[]) {
        try {
            demoThrow();
        } catch (NullPointerException e) {
            System.out.println("I'm catching the exception [" + e + "]\n"
                                +  "thrown from demoThrow methhod");
        }
    }
}

/*
1. Tidak, jika try-catch tidak melakukan rethrow maka catch yang sudah di throw akan 
di tangani oleh kode try-catch yang ada di  dalam class ReThrowEtc
2. Kesimpulan yang didapat adalah bahwa thow digunakan untuk melempar suatuu error ke class yang lain
agar dapat ditangani oleh class tersebut.
*/
