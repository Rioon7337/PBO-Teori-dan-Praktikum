/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

/**
 *
 * @author ASUS
 */
public class Multhread2 {
    public static void main(String[] args) {
        System.out.println("================ PROGRAM MULTI-THREADING DENGAN RUNNABLE"
            + "=================");
        System.out.println("=======================================================");
    
        //Membuat thread dengan karakter, jumlah cetakan, dan delay yang berbeda
        PrintNameThread2[] threads = {
          new PrintNameThread2("A", 25, 50), //A dengan nilai yang berkuasa
          new PrintNameThread2("B", 20, 80), //B dengan delay sedang
          new PrintNameThread2("C", 30, 40), //C dengan delay sangat pendek
          new PrintNameThread2("D", 15, 120), //D dengan delay panjang
          new PrintNameThread2("E", 10, 150) //E dengan delay terpanjang
        };
        
        System.out.println("\nMenunggu semua thread selesai... \n");
        
        //Menunggu semua thread selesai
        try {
            for(PrintNameThread2 thread : threads) {
                thread.getThread().join();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread terinterupsi");
        }
        
        //Menampilkan statistik
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STATISTIK EKSEKUSI THREAD");
        System.out.println("=".repeat(50));
        System.out.println("Jumlah thread yang dijalankan: " + threads.length);
        System.out.println("Total semua thread telah menyelesaikan tugasnya!");
        System.out.println("\nPROGRAM SELESAI DENGAN SUKSES!");
        
        //Animasi akhir yang menarik
        System.out.println("\nAnimasi selesai: ");
        for(int i = 0; i < 3; i++) {
            System.out.print("Hore.. ");
            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
