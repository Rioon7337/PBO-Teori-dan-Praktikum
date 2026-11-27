package com.mycompany.pbo_w12s2_41425034;

import java.time.LocalDate;

// Admin adalah subkelas dari Pengguna
public class Admin extends Pengguna {

    public Admin(String nama, String email, String noTelepon) {
        super(nama, email, noTelepon);
    }

    @Override
    public String getPeran() {
        return "Admin";
    }

    // mengecek ketersediaan barang dalam pesanan
    public void konfirmasiPesanan(Pemesanan pesanan) {
        if (pesanan == null) return;
        System.out.println("Admin mengecek pesanan " + pesanan.getId() + "...");

        for (DetailSewa d : pesanan.getDaftarDetail()) {
            // hanya barang yang masih menunggu yang dicek
            if ("Sedang Dikonfirmasi".equalsIgnoreCase(d.getStatus())) {
                Barang b = d.getBarang();
                if (b != null && "Tersedia".equalsIgnoreCase(b.getStatus())) {
                    // barang tersedia, langsung dipesan supaya tidak diambil orang lain
                    b.setStatus("Dipesan");
                    d.setStatus("Disiapkan");
                    System.out.println("  " + b + " tersedia");
                } else {
                    // barang tidak tersedia, kabari anggota lewat chat
                    String namaBarang = (b != null) ? b.toString() : "Barang";
                    String namaItem = (b != null) ? b.getNamaItem() : "Barang";
                    System.out.println("  " + namaBarang + " TIDAK tersedia");
                    if (pesanan.getAnggota() != null) {
                        pesanan.getAnggota().tambahChat("Admin", "Maaf, " + namaItem
                                + " belum tersedia. Silakan dibatalkan atau ditunggu.");
                    }
                }
            }
        }
        pesanan.updateStatus();
    }

    // mengirim barang yang sudah siap (hanya bisa kalau pesanan sudah dibayar)
    public Pengiriman kirimBarang(Pemesanan pesanan, String metode, LocalDate tanggal) {
        if (pesanan == null) return null;
        if (!pesanan.sudahBayar()) {
            System.out.println("Belum bisa dikirim, pesanan " + pesanan.getId() + " belum dibayar");
            return null;
        }

        boolean adaSiap = false;
        for (DetailSewa d : pesanan.getDaftarDetail()) {
            if ("Disiapkan".equalsIgnoreCase(d.getStatus())) {
                adaSiap = true;
                break;
            }
        }

        if (!adaSiap) {
            System.out.println("Tidak ada barang yang siap dikirim");
            return null;
        }

        Pengiriman kirim = new Pengiriman("PENGIRIMAN", metode, tanggal);
        for (DetailSewa d : pesanan.getDaftarDetail()) {
            // barang yang sudah siap saja yang ikut dikirim (pengiriman bertahap)
            if ("Disiapkan".equalsIgnoreCase(d.getStatus())) {
                kirim.tambahBarang(d);
                d.setStatus("Dikirim");
            }
        }

        pesanan.tambahPengiriman(kirim);
        pesanan.updateStatus();
        return kirim;
    }

    // memproses barang yang masa sewanya sudah habis
    public Pengiriman prosesPengembalian(Pemesanan pesanan, LocalDate hariIni, String metode) {
        if (pesanan == null) return null;

        boolean adaJatuhTempo = false;
        for (DetailSewa d : pesanan.getDaftarDetail()) {
            if ("Dalam Masa Sewa".equalsIgnoreCase(d.getStatus())
                    && d.getTanggalKembali() != null
                    && !d.getTanggalKembali().isAfter(hariIni)) {
                adaJatuhTempo = true;
                break;
            }
        }

        if (!adaJatuhTempo) {
            System.out.println("Belum ada barang yang jatuh tempo pada " + hariIni);
            return null;
        }

        Pengiriman kembali = new Pengiriman("PENGEMBALIAN", metode, hariIni);
        for (DetailSewa d : pesanan.getDaftarDetail()) {
            // cek status dulu: barang yang belum diterima belum punya tanggal kembali
            if ("Dalam Masa Sewa".equalsIgnoreCase(d.getStatus())
                    && d.getTanggalKembali() != null
                    && !d.getTanggalKembali().isAfter(hariIni)) {
                kembali.tambahBarang(d);
                d.setStatus("Dikembalikan");
                if (d.getBarang() != null) {
                    d.getBarang().setStatus("Tersedia");
                }
            }
        }

        pesanan.tambahPengiriman(kembali);
        pesanan.updateStatus();
        return kembali;
    }
}
