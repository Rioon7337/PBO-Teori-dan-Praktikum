/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObject.hashCode_Method;

/**
 *
 * @author ASUS
 */
public class Student {
    int roll;
    
    @Override 
    public int hashCode() {
        return roll;
    }
    
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.roll = 101;
        
        Student s2 = new Student();
        s2.roll = 102;
        
        System.out.println("HashCode s1: " + s1.hashCode());
        System.out.println("HashCode s2: " + s2.hashCode());
    }
}
