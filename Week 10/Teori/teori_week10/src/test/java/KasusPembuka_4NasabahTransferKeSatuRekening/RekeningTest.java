/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KasusPembuka_4NasabahTransferKeSatuRekening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Kelas Rekening sesuai dengan kode Anda
class Rekening01 {
    private double saldo;
    
    // Tambahkan konstruktor jika diperlukan untuk inisialisasi saldo awal, 
    // atau gunakan setter/metod setor sesuai kebutuhan.
    public Rekening01() {
        this.saldo = 0;
    }

    public Rekening01(String noRek, double saldoAwal) {
        this.saldo = saldoAwal;
    }
    
    void setor(double jumlah) {
        saldo += jumlah;
    }

    void tarik(double jumlah) {
        saldo -= jumlah;
    }
    
    double getSaldo(){
        return saldo;
    }
}

// Kelas Unit Test untuk menguji kelas Rekening
public class RekeningTest {
    private Rekening01 rek;

    @BeforeEach
    void siapkan() {
        // Dijalankan sebelum setiap method test untuk menyiapkan data awal
        rek = new Rekening01("A-01", 100_000);
    }

    @Test
    void setorMenambahSaldo() {
        rek.setor(50_000);
        assertEquals(150_000, rek.getSaldo(), 0.001);
    }

    @Test
    void tarikMengurangiSaldo() {
        rek.tarik(30_000);
        assertEquals(80_000, rek.getSaldo(), 0.001);
    }

    @Test
    void tarikSebesarSaldoDiizinkan() {
        rek.tarik(100_000);
        assertEquals(0, rek.getSaldo(), 0.001);
    }
}


