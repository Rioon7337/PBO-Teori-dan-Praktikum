/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author ASUS
 */
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Reminder {

    public static void main(String[] args) {
        Timer timer = new Timer();
        CountDownLatch selesai = new CountDownLatch(1);

        System.out.println("Task scheduled.");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("time's up!");
                timer.cancel();
                selesai.countDown();
            }
        }, 15000);

        try {
            // Program membeku di sini sampai TimerTask selesai (15 detik).
            // Tidak menggunakan Thread.sleep().
            selesai.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
