/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Thread;

/**
 *
 * @author ASUS
 */
public class PrintNameThread extends Thread{
    private int printCount;
    
    PrintNameThread(String name, int printCount) {
        super(name);
        this.printCount = printCount;
        start();
    }
    
    public void run() {
        String name = getName();
        System.out.println("Thread '" + name + "' memulai eksekusi...");
        for (int i = 0; i < printCount; i++) {
            System.out.print(name);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Thread '" + name + "' terinterupsi!");
            }
        }
        
        System.out.println("\nThread '" + name + "' selesai!");
    }
}
