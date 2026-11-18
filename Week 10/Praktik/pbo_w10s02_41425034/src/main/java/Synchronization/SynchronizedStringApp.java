/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Synchronization;

/**
 *
 * @author ASUS
 */
class TwoStringsSync {
    // Method DENGAN sinkronisasi mencegah race condition
    static synchronized void print(String str1, String str2) {
        System.out.print(Thread.currentThread().getName() + " MASUK: '" + str1);
        try {
            Thread.sleep(1000); // Delay untuk menunjukkan efek sinkronisasi
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
        System.out.println(" " + str2 + "'");
    }

    // Alternatif synchronized block
    static void printWithBlock(String str1, String str2) {
        synchronized (TwoStringsSync.class) {
            System.out.print(Thread.currentThread().getName() + " BLOCK: '" + str1);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
            System.out.println(" " + str2 + "'");
        }
    }
}

class PrintStringsThreadSync implements Runnable {
    Thread thread;
    String str1, str2;
    int threadNumber;
    static int threadCounter = 0;
    private boolean useSyncMethod;

    PrintStringsThreadSync(String str1, String str2, boolean useSyncMethod) {
        this.str1 = str1;
        this.str2 = str2;
        this.useSyncMethod = useSyncMethod;
        this.threadNumber = ++threadCounter;
        thread = new Thread(this, "Thread-" + threadNumber);
        System.out.println("Membuat " + thread.getName() + " dengan pesan: '" + str1 + "' '" + str2 + "'");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " memulai eksekusi...");
        if (useSyncMethod) {
            // Menggunakan synchronized method
            TwoStringsSync.print(str1, str2);
        } else {
            // Menggunakan synchronized block
            TwoStringsSync.printWithBlock(str1, str2);
        }
        System.out.println(thread.getName() + " selesai!");
    }
}

public class SynchronizedStringApp {
    public static void main(String args[]) {
        System.out.println("========================================");
        System.out.println("        DEMO DENGAN SINKRONISASI        ");
        System.out.println("========================================\n");
        System.out.println("Program ini menggunakan sinkronisasi untuk mencegah race condition");
        System.out.println("Perhatikan bagaimana output tetap teratur dan tidak tercampur\n");

        System.out.println("BAGIAN 1: SYNCHRONIZED METHOD");
        // Membuat threads dengan synchronized method
        PrintStringsThreadSync[] syncMethodThreads = {
            new PrintStringsThreadSync("Hello", "there!", true),
            new PrintStringsThreadSync("How are ", "you?", true),
            new PrintStringsThreadSync("Thank you", "very much!", true)
        };

        // Menunggu threads pertama selesai
        try {
            for (PrintStringsThreadSync thread : syncMethodThreads) {
                thread.thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("\nBAGIAN 2: SYNCHRONIZED BLOCK");
        // Membuat threads dengan synchronized block
        PrintStringsThreadSync[] syncBlockThreads = {
            new PrintStringsThreadSync("Good", "morning!", false),
            new PrintStringsThreadSync("Have a ", "nice day!", false),
            new PrintStringsThreadSync("See you", "later!", false)
        };

        // Menunggu threads kedua selesai
        try {
            for (PrintStringsThreadSync thread : syncBlockThreads) {
                thread.thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("\n========================================");
        System.out.println("HASIL DENGAN SINKRONISASI:");
        System.out.println("========================================");
        System.out.println("KEUNTUNGAN SINKRONISASI:");
        System.out.println("- Output string tetap teratur dan tidak tercampur");
        System.out.println("- Setiap thread menunggu giliran secara tertib");
        System.out.println("- Bagian str1 dan str2 selalu berpasangan dengan benar");
        System.out.println("- Tidak ada race condition");
        System.out.println("\nTEKNIK SINKRONISASI YANG DIGUNAKAN:");
        System.out.println("  1. Synchronized Method: method print()");
        System.out.println("  2. Synchronized Block: block synchronized (TwoStringsSync.class)");
        System.out.println("\nPROGRAM SELESAI DENGAN SUKSES!");
    }
}
