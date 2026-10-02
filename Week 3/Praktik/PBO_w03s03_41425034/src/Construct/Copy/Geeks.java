/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Construct.Copy;

/**
 *
 * @author ASUS
 */
public class Geeks {
    String name;
    int id;
    
    //Parameterized Constructor
    Geeks(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    //Copy Constructor
    Geeks(Geeks obj2) {
        this.name = obj2.name;
        this.id = obj2.id;
    }
}
