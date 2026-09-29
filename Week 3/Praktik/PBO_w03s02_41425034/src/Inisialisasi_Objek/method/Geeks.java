/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inisialisasi_Objek.method;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/

public class Geeks {
    static String name;
    static float price;
    
    static void set(String n, float p) {
        name = n;
        price = p;
    }
    
    static void get() {
        System.out.println("Software name is: " + name);
        System.out.println("Software price is: " + price);
    }
    
    public static void main(String args[]) {
        Geeks.set("Visual studio", 0.0f);
        Geeks.get();
    }
}
