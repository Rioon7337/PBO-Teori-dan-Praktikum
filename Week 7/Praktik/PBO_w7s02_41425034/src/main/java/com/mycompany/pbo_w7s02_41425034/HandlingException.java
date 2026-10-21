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
public class HandlingException {
  public static void main(String[] args) {
      try {
          System.out.println(3/0);
      } catch(Exception ex) {
      //catch (ArithmeticException ex) {
          ex.printStackTrace();
          System.out.println("Error " + ex);
          System.out.println("Error " + ex.getMessage());
          System.out.println("Error " + ex.getStackTrace());
      }
      System.out.println("Program selesai");
  }  
}

/*
1. Saat mengeksekusi ex.getMessage() maka sistem hanya akan mengembalikan pesan error
yang berupa "/ by zero", sedangkan ex.getStackTrace() akan mengembalikan referensi objek 
dari stack trace.
Jika dilakukan eksekusi statement ex.printStackTrace() maka sistem akan mengembalikan hasil yang
sama dengan ketika sistemm mengembalikan ex namun memberikan hasil yang lebih lengkap
2. Hasil dari penggunaan Exception menghasilkan hasil error yang sama, hall ini disebabkan 
karena ArtithmeticException merupakan bagian dari Exception sehingga semua bagian yang ada
dibawah Exception akan dapat diakses oleh Exception.
*/
