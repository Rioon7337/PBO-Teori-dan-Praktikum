/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buat_Object_Class.Beberapa_Objek;

/**
 *
 * @author ASUS
 */
public class Test {
    public static void main(String[] args) {
        Animal obj = new Dog(); //Menggunakan Dog Object
        Cat obj1 = new Cat();        //Menggunakan Cat Object
        //kenapa kalau ngak pakai Animal di depan obj itu salah?
        //tanpa tipe (Animal) compiler mengira bahwa obj1 adalah nama variabel yang bekum ada
        
        obj.suara();
        obj1.suara();
    }
    
}
