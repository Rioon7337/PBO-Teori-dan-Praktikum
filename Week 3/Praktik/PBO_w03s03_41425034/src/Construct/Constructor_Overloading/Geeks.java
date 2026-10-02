/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Construct.Constructor_Overloading;

/**
 *
 * @author ASUS
 */
public class Geeks {
    //Constructor with one argument
    Geeks(String name) {
        System.out.println("Constructor with one "
                            + "argument - String: " + name);
    }
    
    //Constructor with two argument
    Geeks(String name, int age) {
        System.out.println("Constructor with two argument:  "
        + " String and Integer: " + name + " " + age);
    }
    
    //Constructor with one argument but with different
    Geeks(Long id) {
        System.out.println("Constructor with one argument: "
                            + "Long: " + id);
    }
}
