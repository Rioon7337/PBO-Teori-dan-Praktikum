/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObject.Concurrency_Methods;

/**
 *
 * @author ASUS
 */
class AntreanShared {
    private String data;
    private boolean adaData = false;
    
    //Method untuk memproduksi data
    public synchronized void kirimPesan(String pesan) {
        while (adaData) {
            try {
                //Menunggu hingga pesan sebelumnya diambil/dikonsumsi
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = pesan;
        this.adaData = true;
        System.out.println("Pesan dikirim: " + pesan);
        
        //Memberitahu thread konsumen bahwa data sudah siap
        notify();
    }
    
    //Method untuk mengambil data
    public synchronized String ambilPesan() {
        while (!adaData) {
           try {
               //Menunggu hingga pesan tersedia
               wait();
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
        }
        this.adaData = false;
        System.out.println("Pesan diterima: " + data);
        
        //Memberitahu thread produsen bahwa tempat sudah kosong
        notify();
        return data;
    }
}
