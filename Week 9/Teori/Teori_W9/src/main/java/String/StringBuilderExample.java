/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package String;

/**
 *
 * @author ASUS
 */
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);
        sb.append(" World");       // Menggabungkan teks -> "Hello World"
        System.out.println(sb);
        sb.insert(0, ", Java");    // Menyisipkan teks pada indeks ke-5 -> "Hello, Java World"
        System.out.println(sb);    // Output: Hello, Java World
        sb.insert(12, "Contoh");
        System.out.println(sb);
    }
 
}
