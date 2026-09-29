/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Object.clone;

/*
Nama  : Johannes Rein Gerardo Lumban Tobing
NIM   : 41425034
Prodi : D4 TRPL
*/

public class Book implements Cloneable{ 
    private String t;
    public Book(String t) {
        this.t = t;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public String getTitle() {
        return t;
    }
    
    public static void main(String[] args) {
        try {
                Book b1 = new Book("Java Basics");
                Book b2 = (Book) b1.clone);
                
                System.out.println("judul buku b1: " + b1.getTitle());
                System.out.println("Judul buku b2: " + b2.getTitle());
                System.out.println("Apakah b1 dan b2 objek yang sama? " + (b1 == b2));
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }
        
}
