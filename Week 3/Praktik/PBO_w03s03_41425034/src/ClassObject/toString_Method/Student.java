/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObject.toString_Method;

/**
 *
 * @author ASUS
 */
public class Student {
    @Override
    public String toString() {
        return "Student Object";
    }
    
    public static void main(String[] args) {
        Student s = new Student(); //membuat object Student
        System.out.println(s.toString()); // memanggil toString()
    }
}
