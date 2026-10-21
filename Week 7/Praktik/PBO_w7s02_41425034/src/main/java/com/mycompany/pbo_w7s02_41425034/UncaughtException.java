/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pbo_w7s02_41425034;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/
public class UncaughtException {

    public static void main(String[] args) {
        System.out.println(3/0);
    }
}

/*
1. Pada kode program tersebut akan terjadi runtime error karena program mencoba 
membagi 3 dengan nol yang hasilnya adalah tidak terdefinisi dan program akan mengembalikan
hasil ArithmaticException.
2. Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.mycompany.pbo_w7s02_41425034.UncaughtException.main(UncaughtException.java:15)
*/
