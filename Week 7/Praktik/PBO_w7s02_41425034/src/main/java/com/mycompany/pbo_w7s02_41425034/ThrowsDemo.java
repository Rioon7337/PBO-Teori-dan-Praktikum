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
public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("I'm throwing a non Runtime exception that I "
                + "don't handle");
        System.out.println("Without specifying in method declaration");
        throw new IllegalAccessException("demo"); 
    }

    public static void main(String args[]) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
    }
}

/*
1. Kode program tersebut akan menjadi error karena IllegalAccessException tidak termasuk ke
dalam jenis Exception tipe runtime maupun I/O sehingga seharusnya langsung ditangani saat
itu juga.
2. Pada kode tersebuut tidak terjadi error karena checked exception sudah dideklarasikan dengan 
memberikan throws pada nama method.
*/