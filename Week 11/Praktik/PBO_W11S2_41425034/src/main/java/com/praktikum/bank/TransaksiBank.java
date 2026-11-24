/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.praktikum.bank;

/**
 *
 * @author ASUS
 */
public class TransaksiBank {

    public static void main(String[] args) throws InterruptedException {
        RekeningBank rekening1 = new RekeningBank(0, 001);
        Thread[] threads = new Thread[100];
        
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> rekening1.setor(1000));
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        String[] pengguna = {
            
        };
        
        System.out.println("Saldo seharusnya : 100000");
        System.out.println("Saldo aktual     : " + rekening1.getSaldo());
    }
}
