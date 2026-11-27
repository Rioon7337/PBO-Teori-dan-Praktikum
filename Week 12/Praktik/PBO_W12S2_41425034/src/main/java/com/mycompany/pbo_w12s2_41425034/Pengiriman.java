package com.mycompany.pbo_w12s2_41425034;

import java.time.LocalDate;
import java.util.ArrayList;

// Satu kali pengiriman atau pengembalian barang
public class Pengiriman implements Biaya {

    // penghitung untuk nomor resi otomatis
    private static int nomorTerakhir = 0;

    private String nomorResi;
    private String jenis;      // PENGIRIMAN atau PENGEMBALIAN
    private String metode;     // AMBIL_DI_GUDANG, DIKIRIM_KE_ALAMAT, KEMBALI_KE_GUDANG, DIJEMPUT_DI_ALAMAT
    private LocalDate tanggal;
    private int ongkos;
    private ArrayList<DetailSewa> daftarBarang = new ArrayList<DetailSewa>();

    public Pengiriman(String jenis, String metode, LocalDate tanggal) {
        nomorTerakhir++;
        this.nomorResi = String.format("RSI-%04d", nomorTerakhir);
        this.jenis = jenis;
        this.metode = metode;
        this.tanggal = tanggal;

        // ongkos hanya ada kalau barang diantar atau dijemput ke alamat
        if ("DIKIRIM_KE_ALAMAT".equalsIgnoreCase(metode) || "DIJEMPUT_DI_ALAMAT".equalsIgnoreCase(metode)) {
            this.ongkos = 10000;
        } else {
            this.ongkos = 0;
        }
    }

    public String getNomorResi() {
        return nomorResi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public void tambahBarang(DetailSewa d) {
        if (d != null) {
            daftarBarang.add(d);
        }
    }

    public ArrayList<DetailSewa> getDaftarBarang() {
        return daftarBarang;
    }

    // dipanggil saat barang sampai di tangan penyewa
    public void tandaiDiterima(LocalDate tanggalTerima) {
        for (DetailSewa d : daftarBarang) {
            if ("Dikirim".equalsIgnoreCase(d.getStatus())) {
                d.catatTanggalSewa(tanggalTerima);
                d.setStatus("Dalam Masa Sewa");
                if (d.getBarang() != null) {
                    d.getBarang().setStatus("Disewa");

                    // kalau barang ini milik anggota, pemiliknya dapat royalti
                    Anggota pemilik = d.getBarang().getPemilik();
                    if (pemilik != null) {
                        int royalti = d.getHargaSewa() * pemilik.getPersenRoyalti() / 100;
                        pemilik.tambahSaldo(royalti);
                        System.out.println("  Royalti Rp" + royalti + " untuk " + pemilik.getNama());
                    }
                }
            }
        }
    }

    public int getOngkos() {
        return ongkos;
    }

    public void setOngkos(int ongkos) {
        this.ongkos = ongkos;
    }

    @Override
    public int hitungTotal() {
        return ongkos;
    }

    @Override
    public String getKeterangan() {
        return jenis + " " + nomorResi;
    }

    public void tampilkan() {
        System.out.println("--- " + jenis + " " + nomorResi + " ---");
        System.out.println("Metode : " + metode);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Ongkos : Rp" + ongkos);
        for (DetailSewa d : daftarBarang) {
            System.out.println("  - " + d.getBarang());
        }
    }
}
