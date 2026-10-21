/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week6.sesi2;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Hewan obj = new Kucing();
        
        obj.suara();
        obj.tidur();
        //obj.bergerak();
        //ini akan error karena pada instansiasi Class Reference menggunakan Hewan
        //sebagai referensi sehingga jika di run sistem tidak dapat menemukan method 
        //bergerak di class Hewan. Ini berbeda dengan method tidur dimana method tidur
        //terdapat di abstract class dan jika di jalankan sistem akan mencari methhod 
        //tidur di Hewan dan jika ada di class Kucing maka sistem akan menjalankan
        //yang ada di class Kucing
    }
}
