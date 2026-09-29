/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inisialisasi_Objek.reflection;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/

public class Main {
    public static void main(String[] args) {
        try{
            Class<?> c = Class.forName("Student");
            Student s2 = (Student) c.getDeclaredConstructor().newInstance();
            System.out.println("Object created " + s2);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found!");
        } catch (NoSuchMethodException e) {
            System.err.println("No default constructor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
