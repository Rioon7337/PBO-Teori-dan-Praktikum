package com.mycompany.pbo_w12s2_41425034;

import java.time.LocalDate;

// Satu barang di dalam sebuah pesanan, lengkap dengan lama sewa dan statusnya
public class DetailSewa {

    private Barang barang;
    private int lamaBulan;
    private int hargaSewa;
    private String status;
    private LocalDate tanggalSewa;
    private LocalDate tanggalKembali;

    public DetailSewa(Barang barang, int lamaBulan, String levelPenyewa) {
        this.barang = barang;
        this.lamaBulan = lamaBulan;
        this.status = "Sedang Dikonfirmasi";
        // 1 bulan dihitung 4 pekan
        int hargaPerPekan = (barang != null) ? barang.getHargaPerPekan(levelPenyewa) : 0;
        this.hargaSewa = hargaPerPekan * 4 * lamaBulan;
    }

    // dipanggil saat barang sudah sampai di tangan penyewa
    public void catatTanggalSewa(LocalDate tanggal) {
        this.tanggalSewa = tanggal;
        this.tanggalKembali = tanggal.plusMonths(lamaBulan);
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getLamaBulan() {
        return lamaBulan;
    }

    public void setLamaBulan(int lamaBulan) {
        this.lamaBulan = lamaBulan;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTanggalSewa() {
        return tanggalSewa;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    @Override
    public String toString() {
        String hasil = barang + " | " + lamaBulan + " bulan | Rp" + hargaSewa + " | " + status;
        if (tanggalKembali != null) {
            hasil = hasil + " | kembali " + tanggalKembali;
        }
        return hasil;
    }
}
