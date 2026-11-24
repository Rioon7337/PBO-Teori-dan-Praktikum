/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.praktikum.bank;

/**
 *
 * @author ASUS
 */
public class RekeningBank {
    private int saldo;
    private final int noRekening;
    
    public RekeningBank(int saldoAwal, int noRekening) {
        this.saldo = saldoAwal;
        this.noRekening = noRekening;
    }
    
    /*public void setor(int jumlah) {
        int saldoSementara = this.saldo;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.saldo = saldoSementara + jumlah;
    }
    
    public void tarik(int jumlah) {
        if (this.saldo >= jumlah) {
            int saldoSementara = this.saldo;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.saldo = saldoSementara - jumlah;
        }
    }*/
    
    public synchronized void setor(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah setor harus lebih dari 0");
        }
        int saldoSementara = this.saldo;
        
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.saldo = saldoSementara + jumlah;
        
        notifyAll();
    }
    
    public synchronized void tarikDenganTunggu(int jumlah) throws InterruptedException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }
        
        while (this.saldo < jumlah) {
            wait();
        } 
        
        this.saldo -= jumlah;
    }
    
    public synchronized int getSaldo() {
        return saldo;
    }
    
    public synchronized boolean tarikDenganTunggu(int jumlah, long timeoutMillis) throws InterruptedException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0");
        }
        
        long waktuMulai = System.currentTimeMillis();
        long waktuSisa = timeoutMillis;

        while (this.saldo < jumlah) {
            if (waktuSisa <= 0) {
                return false; // Timeout tercapai dan saldo belum mencukupi
            }
            wait(waktuSisa); // Menunggu dengan batas waktu tertentu
            waktuSisa = timeoutMillis - (System.currentTimeMillis() - waktuMulai);
        }

        this.saldo -= jumlah;
        return true; // Berhasil menarik dana
    }

    public void transfer(RekeningBank tujuan, int jumlah) throws InterruptedException {
        
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah transfer harus lebih dari 0");
        }
        if (tujuan == null) {
            throw new IllegalArgumentException("Rekening tujuan tidak boleh null");
        }
        if (this == tujuan) {
            throw new IllegalArgumentException("Tidak dapat mentransfer ke rekening yang sama");
        }

        // Menentukan urutan penguncian berdasarkan idRekening untuk mencegah Deadlock
        RekeningBank lockPertama = (this.noRekening < tujuan.noRekening) ? this : tujuan;
        RekeningBank lockKedua = (this.noRekening < tujuan.noRekening) ? tujuan : this;

        synchronized (lockPertama) {
            synchronized (lockKedua) {
                if (this.saldo < jumlah) {
                    throw new IllegalStateException("Saldo tidak mencukupi untuk transfer");
                }
                // Proses pemindahan saldo secara atomik
                this.saldo -= jumlah;
                tujuan.saldo += jumlah;
                
                // Memberitahu thread lain yang mungkin menunggu di rekening tujuan
                tujuan.notifyAll();
            }
        }
    }
}
