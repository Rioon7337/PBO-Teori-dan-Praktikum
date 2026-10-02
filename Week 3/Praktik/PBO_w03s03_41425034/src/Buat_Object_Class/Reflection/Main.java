/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buat_Object_Class.Reflection;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        try {
            //program ini memberikan hasil Class Not Found karena class Student
            //tidak hanya dideklarasikan di package ini saja, tetapi juga di package default
            //sehingga diperlukan nama lengkap class (Package + Class)
            //tanpa adanya nama lengkap program akan mencari di package Default
            Class<?> c = Class.forName("Student");
            //Class<?> c = Class.forName("Buat_Object_Class.Reflection.Student");
            Student s2 = (Student) c.getDeclaredConstructor().newInstance();
            System.out.println("Objek created: " + s2);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found!");
        } catch (NoSuchMethodException e) {
            System.err.println("No default constructor  here");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
