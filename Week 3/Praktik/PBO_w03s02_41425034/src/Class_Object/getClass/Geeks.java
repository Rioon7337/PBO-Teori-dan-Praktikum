/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object.getClass;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/

public class Geeks {
    public static void main(String[] args) {
        Object o = new String("GeeksForGeeks");
        Class c = o.getClass();
        System.out.println("Class of Object o is: " + c.getName());
    }
}
