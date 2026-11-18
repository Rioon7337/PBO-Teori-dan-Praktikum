/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author ASUS
 */
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TanggalWaktu {

    public static void main(String[] args) {
        System.out.println("Program started");

        Timer timer = new Timer();

        // Tugas berulang: mulai langsung (delay 0), lalu diulang setiap 10 detik.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time started at:" + new Date());

                try {
                    Thread.sleep(5000); // pekerjaan berlangsung 5 detik
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Time finished at:" + new Date());
            }
        }, 0, 10000);

        // Tugas pembatal: dijalankan setelah 27 detik untuk menghentikan timer.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Program cancelled");
                timer.cancel();
            }
        }, 27000);
    }
}