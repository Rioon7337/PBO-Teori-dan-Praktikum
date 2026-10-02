/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buat_Object_Class.Deserialization;

/**
 *
 * @author ASUS
 */

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    public Student(String name) {
        this.name = name;
    }
    
    @Override public String toString() {
        return "Student{name= " + name + "}";
    }
}
