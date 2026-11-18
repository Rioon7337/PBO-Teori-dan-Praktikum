/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

/**
 *
 * @author ASUS
 */
public class MultiThread {
    public static void main(String[] args) {
        System.out.println("=== PROGRAM MULTI-THREADING ===");
        System.out.println("Memulai 5 thread yang akan mencetak karakter...\n");
        
        PrintNameThread[] threads = {
            new PrintNameThread("A", 10),
            new PrintNameThread("B", 10),
            new PrintNameThread("C", 10),
            new PrintNameThread("D", 10),
            new PrintNameThread("E", 10)
        };
        
        for(PrintNameThread thread : threads) {
            try {
                thread.join();
            } catch(InterruptedException e) {
                System.out.println("Main thread terinterupsi!");
            }
        }
        
        System.out.println("\n=== SEMUA THREAD TELAH SELESAI");
        System.out.println("Program selesai dijalankan!");
    }
}
