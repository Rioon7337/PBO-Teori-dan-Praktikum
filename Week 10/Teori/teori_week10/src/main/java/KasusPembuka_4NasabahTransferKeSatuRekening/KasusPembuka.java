/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KasusPembuka_4NasabahTransferKeSatuRekening;

/**
 *
 * @author ASUS
 */
class Rekening {
    private double saldo;
    
    synchronized void setor(double jumlah) {
        saldo += jumlah;
    }
    
    synchronized double getSaldo(){
        return saldo;
    }
}


public class KasusPembuka {
    public static void main(String[] args) throws InterruptedException{
        int inti = Runtime.getRuntime().availableProcessors();
        Rekening r = new Rekening();
        Thread[] nasabah = new Thread[4];
        
        System.out.println(inti);
        
        for (int k = 0; k < 4; k++) {
            nasabah[k] = new Thread(() -> {
                for (int i = 0; i < 100_000; i++) r.setor(1);
            });
            nasabah[k].start();
        }
        
        for(Thread t: nasabah) t.join();
        
        System.out.println("Saldo akhir: " + r.getSaldo());
        System.out.println("Seharusnya : 400000");
    }
}
