/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObject.hashCode_Equals_Method;

/**
 *
 * @author ASUS
 */
public class Student {
    int roll;
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            return this.roll == ((Student) o).roll;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.roll = 101;
        
        Student s2 = new Student();
        s2.roll = 101;
        
        Student s3 = new Student();
        s3.roll = 102;
        
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }
}
