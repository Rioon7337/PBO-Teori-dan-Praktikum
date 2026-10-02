/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buat_Object_Class.Deserialization;

/**
 *
 * @author ASUS
 */
// Kode program error dikarenakan tidak adanya Class Student yang diserialisasi
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        //serialization 
        try (ObjectOutputStream out
                = new ObjectOutputStream(
                    new FileOutputStream("student.ser"))) {
            out.writeObject(new Student("Alice"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //deserialization
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("student.ser"))) {
            Student s = (Student)in.readObject();
            System.out.println(s);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

