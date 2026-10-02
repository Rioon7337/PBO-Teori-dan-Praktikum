/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Construct.Parameterized;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        //This would invoke the paramterized constructor
        Geeks geek1 = new Geeks("Sweta", 68);
        System.out.println("GeekName: " + geek1.name
                            + " and GeekId: " + geek1.id);
    }
}
