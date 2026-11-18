/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Synchronization;

/**
 *
 * @author ASUS
 */
class TwoStrings {
    // Method TANPA sinkronisasi - akan menyebabkan race condition
    static void print(String str1, String str2) {
        System.out.print(Thread.currentThread().getName() + ": '" + str1);
        try {
            Thread.sleep(1000); // Delay untuk memperjelas race condition
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
        System.out.println(" " + str2 + "'");
    }
}

class PrintStringsThread implements Runnable {
    Thread thread;
    String str1, str2;
    int threadNumber;
    static int threadCounter = 0;

    PrintStringsThread(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.threadNumber = ++threadCounter;
        thread = new Thread(this, "Thread-" + threadNumber);
        System.out.println("Membuat " + thread.getName() + " dengan pesan: '" + str1 + "' '" + str2 + "'");
        thread.start();
    }

    public void run() {
        System.out.println(thread.getName() + " memulai eksekusi...");
        // Memanggil method TANPA sinkronisasi
        TwoStrings.print(str1, str2);
        System.out.println(thread.getName() + " selesai!");
    }
}

public class UnsynchronizedStringApp {
    public static void main(String args[]) {
        System.out.println("========================================");
        System.out.println(" DEMO RACE CONDITION TANPA SINKRONISASI ");
        System.out.println("========================================");
        System.out.println("Program ini sengaja TIDAK menggunakan sinkronisasi");
        System.out.println("Perhatikan bagaimana output akan tercampur (race condition)\n");

        // Membuat multiple threads dengan pesan yang berbeda
        PrintStringsThread[] threads = {
            new PrintStringsThread("Hello", "there!"),
            new PrintStringsThread("How are ", "you?"),
            new PrintStringsThread("Thank you", "very much!"),
            new PrintStringsThread("Good", "morning!"),
            new PrintStringsThread("Have a ", "nice day!")
        };

        System.out.println("\nMenunggu semua thread selesai...\n");

        // Menunggu semua thread selesai
        try {
            for (PrintStringsThread thread : threads) {
                thread.thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("ANALISIS RACE CONDITION:");
        System.out.println("-".repeat(60));
        System.out.println("MASALAH YANG TERJADI:");
        System.out.println("- Output string tercampur antara thread");
        System.out.println("- Bagian str1 dan str2 tidak selalu berpasangan dengan benar");
        System.out.println("- Thread saling menginterupsi saat akses shared resource");
        System.out.println("\nSOLUSI:");
        System.out.println("- Gunakan synchronized method atau block");
        System.out.println("- Gunakan lock objects");
        System.out.println("- Gunakan atomic variables");
        System.out.println("\nDEMO SELESAI!");
    }
}
