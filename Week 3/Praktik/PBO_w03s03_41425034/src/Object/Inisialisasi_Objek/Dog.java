/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object.Inisialisasi_Objek;

/**
 *
 * @author ASUS
 */
public class Dog {
    String name;
    String breed;
    int age;
    String color;
    
    //Constructor
    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }
    
    //method 1
    public String getName() {
        return name;
    }
    
    //method 2
    public String getBreed() {
        return breed;
    }
    
    //method 3
    public int getAge() {
        return age;
    }
    
    //method 4
    public String getColor() {
        return color;
    }
    
    @Override public String toString() {
        return ("Name is: " + this.getName()
                + "\nBreed, age, color are: "
                + this.getBreed() + ", " + this.getAge()
                + ", " + this.getColor());
    }
    
    public static void main(String[] args) {
        Dog tuffy = new Dog("tuffy", "papillon", 5, "white");
        
        System.out.println(tuffy.toString());
    } 
}
