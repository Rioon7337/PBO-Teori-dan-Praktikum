/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.praktikum.bank;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
public class RekeningBankTest {
    
    private RekeningBank rekening;
    
    
    @BeforeEach
    public void setUp() {
        rekening = new RekeningBank(0, 1);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    @DisplayName("Skenario 1: Transaksi setor dan tarik normal secara sekuensial")
    public void testTransaksiNormal() throws InterruptedException {
        rekening.setor(50000);
        rekening.tarikDenganTunggu(20000);
        assertEquals(30000, rekening.getSaldo(), "Saldo akhir harus tepat secara sekuensial");
    }

    @Test
    @DisplayName("Skenario 2: Input nominal negatif atau nol harus melempar Exception")
    public void testInputTidakValid() {
        assertThrows(IllegalArgumentException.class, () -> {
            rekening.setor(-5000);
        }, "Setor negatif harus ditolak dengan IllegalArgumentException");
    }

    @Test
    @DisplayName("Skenario 3: Bebas Race Condition pada eksekusi 100 Thread Bersamaan")
    public void testConcurrencySetor() throws InterruptedException {
        int jumlahThread = 100;
        int nominalSetor = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch latch = new CountDownLatch(jumlahThread);
        
        for (int i = 0; i < jumlahThread; i++) {
            executor.submit(() -> {
                try {
                    rekening.setor(nominalSetor);
                } finally {
                    latch.countDown();
                }
            });
        }
        
        latch.await();
        executor.shutdown();
        
        assertEquals(100000, rekening.getSaldo(),
            "Saldo harus tepat 100000 tanpa kehilangan data akibat race condition");
    }
    
    @Test
    @DisplayName("Skenario 4: Koordinasi Thread menggunakan wait() dan notifyAll()")
    void testWaitNotifyTarikTunggu() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            Thread threadPenarik = new Thread(() -> {
                try{
                    rekening.tarikDenganTunggu(50000);
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            Thread threadPenyetor = new Thread(() -> {
                try {
                    Thread.sleep(200);
                    rekening.setor(70000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            threadPenarik.start();
            threadPenyetor.start();
            
            threadPenarik.join();
            threadPenyetor.join();
            
            assertEquals(20000, rekening.getSaldo(),
                    "Thread penarik harus menunggu penyetor, lalu saldo tersisa 20000");
            
        });
    }
    
    @Test
    @DisplayName("Skenario 5: Transfer paralel antar rekening menjaga konsistensi total saldo")
    void testTransferParalel() throws InterruptedException {
        RekeningBank rekeningA = new RekeningBank(100000, 001);
        RekeningBank rekeningB = new RekeningBank(50000, 002);
        
        int jumlahThread = 50;
        int nominalTransfer = 500;
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(jumlahThread * 2);

        // 50 thread mentransfer dari A ke B
        for (int i = 0; i < jumlahThread; i++) {
            executor.submit(() -> {
                try {
                    rekeningA.transfer(rekeningB, nominalTransfer);
                } catch (Exception e) {
                    fail("Transfer A ke B gagal: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        // 50 thread mentransfer balik dari B ke A
        for (int i = 0; i < jumlahThread; i++) {
            executor.submit(() -> {
                try {
                    rekeningB.transfer(rekeningA, nominalTransfer);
                } catch (Exception e) {
                    fail("Transfer B ke A gagal: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();

        // Total keseluruhan saldo awal (100000 + 50000 = 150000) harus tetap konsisten
        int totalSaldoAkhir = rekeningA.getSaldo() + rekeningB.getSaldo();
        assertEquals(150000, totalSaldoAkhir, "Total saldo keseluruhan harus tetap konsisten (150000)");
        assertEquals(100000, rekeningA.getSaldo(), "Saldo rekening A harus kembali seperti semula");
        assertEquals(50000, rekeningB.getSaldo(), "Saldo rekening B harus kembali seperti semula");
    }

    @Test
    @DisplayName("Skenario 6: Penanganan timeout saat saldo tidak mencukupi dan penyetor tidak datang")
    void testTarikDenganTimeoutGagal() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            boolean hasil = false;
            try {
                // Mencoba menarik 50000 dengan batas waktu tunggu 300 milidetik (tanpa ada penyetor)
                hasil = rekening.tarikDenganTunggu(50000, 300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                fail("Thread terinterupsi secara tidak terduga");
            }
            
            // Memastikan method mengembalikan false karena timeout tercapai
            assertFalse(hasil, "Penarikan harus gagal/mengembalikan false karena timeout");
            assertEquals(0, rekening.getSaldo(), "Saldo harus tetap 0 karena penarikan dibatalkan");
        });
    }

    @Test
    @DisplayName("Skenario 7: Keberhasilan penarikan dengan timeout jika penyetor datang tepat waktu")
    void testTarikDenganTimeoutBerhasil() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            Thread threadPenarik = new Thread(() -> {
                try {
                    // Menunggu hingga 1000ms untuk penarikan 40000
                    boolean hasil = rekening.tarikDenganTunggu(40000, 1000);
                    assertTrue(hasil, "Penarikan harus berhasil sebelum timeout");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread threadPenyetor = new Thread(() -> {
                try {
                    Thread.sleep(200); // Penyetor datang setelah 200ms
                    rekening.setor(60000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            threadPenarik.start();
            threadPenyetor.start();

            threadPenarik.join();
            threadPenyetor.join();

            assertEquals(20000, rekening.getSaldo(), "Saldo sisa harus tepat 20000 setelah ditarik");
        });
    }
    
}
