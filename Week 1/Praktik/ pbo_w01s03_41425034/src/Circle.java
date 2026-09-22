/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */

//define the Circle class
public class Circle { //save as "Circle.java"
    //private variables
    double radius;
    private String color;
    
    //constructors (overloaded)  
    public Circle() {   //1st constructor
        radius = 1.0;
        color = "red";
    }
    public Circle(double r) {   //2nd constructor
        radius = r;
        color = "red";
    }
    public Circle (double r, String c) {    //3rd constructor
        radius = r;
        color = c;
    }
    
    //public methods
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public double getArea() {
        return radius*radius*Math.PI;
    }
}
