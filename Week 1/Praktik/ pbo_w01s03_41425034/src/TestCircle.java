/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */

//test driver program for the circle class
public class TestCircle { //save as "TestCircle.java"
    public static void main(String[] args) { //execution entry point
        //construct an instance of the Circle class called c1
        Circle c1 = new Circle(2.0, "blue"); //use 3rd constructor
        c1.radius = 10.0;
        System.out.println("Radius is " + c1.getRadius() //use dot operator to invoke member methods
                + " Color is " + c1.getColor()
                + " Area is " + c1.getArea());
        
        //construct another instance of the Circle class called c2
        Circle c2 = new Circle(2.0); //use 2nd constructor
        System.out.println("Radius is " + c2.getRadius()
            + " Color is " + c2.getColor()
            + " Area is " + c2.getArea());
        
        //construct yet another isntance of the Circle class called c3
        Circle c3 = new Circle(); //use 1st constructor
        System.out.println("Radius is " + c3.getRadius()
            + " Color is " + c3.getColor()
            + " Area is " + c3.getArea());
    }
    
}
