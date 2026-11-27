package com.mycompany.pbo_w12s2_41425034;

import java.time.LocalDate;
import java.util.ArrayList;

// Pesanan yang dibuat anggota. Satu pesanan bisa berisi beberapa barang.
public class Pemesanan implements Biaya {

    // penghitung untuk membuat ID otomatis
    private static int nomorTerakhir = 0;

    private String id;
    private Anggota anggota;
    private String alamatTujuan;
    private LocalDate tanggalPesan;
    private String status;
    private boolean sudahBayar = false;
    private ArrayList<DetailSewa> daftarDetail = new ArrayList<DetailSewa>();
    private ArrayList<Pengiriman> daftarPengiriman = new ArrayList<Pengiriman>();

    public Pemesanan(Anggota anggota, String namaAlamat, LocalDate tanggalPesan) {
        nomorTerakhir++;
        this.id = String.format("PSN-%04d", nomorTerakhir);
        this.anggota = anggota;
        this.alamatTujuan = (anggota != null) ? anggota.getAlamat(namaAlamat) : "";
        this.tanggalPesan = tanggalPesan;
        this.status = "Sedang Dikonfirmasi";
        if (anggota != null) {
            anggota.tambahRiwayatPesanan(this);
        }
    }

    // anggota menambah barang ke pesanan, harga mengikuti level anggota saat ini
    public void tambahBarang(Barang barang, int lamaBulan) {
        String level = (anggota != null) ? anggota.getLevel() : "Bronze";
        DetailSewa d = new DetailSewa(barang, lamaBulan, level);
        daftarDetail.add(d);
    }

    // pembayaran hanya bisa dilakukan kalau status sudah "Menunggu Pembayaran"
    public void bayar() {
        if (!"Menunggu Pembayaran".equalsIgnoreCase(status)) {
            System.out.println("Belum bisa bayar. Status sekarang: " + status);
            return;
        }
        sudahBayar = true;
        // setiap Rp10.000 total sewa dapat 1 poin
        int poinDidapat = hitungTotalSewa() / 10000;
        if (anggota != null) {
            anggota.tambahPoin(poinDidapat);
        }
        System.out.println(id + " sudah dibayar, dapat " + poinDidapat + " poin");
        updateStatus();
    }

    // membatalkan barang yang belum dikirim
    public void batalkan() {
        for (DetailSewa d : daftarDetail) {
            if ("Sedang Dikonfirmasi".equalsIgnoreCase(d.getStatus())) {
                d.setStatus("Batal");
            } else if ("Disiapkan".equalsIgnoreCase(d.getStatus())) {
                if (d.getBarang() != null) {
                    d.getBarang().setStatus("Tersedia"); // reservasi dilepas
                }
                d.setStatus("Batal");
            }
        }
        updateStatus();
    }

    public void tambahPengiriman(Pengiriman kirim) {
        if (kirim != null) {
            daftarPengiriman.add(kirim);
        }
    }

    // menentukan status pesanan dari status semua barangnya
    public void updateStatus() {
        boolean semuaBatal = true;
        boolean semuaSelesai = true;
        boolean adaDisewa = false;
        boolean adaDikirim = false;
        boolean adaDisiapkan = false;

        for (DetailSewa d : daftarDetail) {
            String s = d.getStatus();
            if (!"Batal".equalsIgnoreCase(s)) {
                semuaBatal = false;
            }
            if (!"Dikembalikan".equalsIgnoreCase(s) && !"Batal".equalsIgnoreCase(s)) {
                semuaSelesai = false;
            }
            if ("Dalam Masa Sewa".equalsIgnoreCase(s)) {
                adaDisewa = true;
            }
            if ("Dikirim".equalsIgnoreCase(s)) {
                adaDikirim = true;
            }
            if ("Disiapkan".equalsIgnoreCase(s)) {
                adaDisiapkan = true;
            }
        }

        if (daftarDetail.isEmpty()) {
            status = "Sedang Dikonfirmasi";
        } else if (semuaBatal) {
            status = "Batal";
        } else if (semuaSelesai) {
            status = "Dikembalikan";
        } else if (adaDisewa) {
            status = "Dalam Masa Sewa";
        } else if (adaDikirim) {
            status = "Dikirim";
        } else if (adaDisiapkan) {
            if (sudahBayar) {
                status = "Disiapkan";
            } else {
                status = "Menunggu Pembayaran";
            }
        } else {
            status = "Sedang Dikonfirmasi";
        }
    }

    // total harga sewa semua barang yang tidak dibatalkan
    public int hitungTotalSewa() {
        int total = 0;
        for (DetailSewa d : daftarDetail) {
            if (!"Batal".equalsIgnoreCase(d.getStatus())) {
                total = total + d.getHargaSewa();
            }
        }
        return total;
    }

    // total ongkos dari semua pengiriman dan pengembalian
    public int hitungTotalOngkos() {
        int total = 0;
        for (Pengiriman k : daftarPengiriman) {
            total = total + k.hitungTotal();
        }
        return total;
    }

    @Override
    public int hitungTotal() {
        return hitungTotalSewa() + hitungTotalOngkos();
    }

    @Override
    public String getKeterangan() {
        return "Pesanan " + id;
    }

    public String getId() {
        return id;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }

    public LocalDate getTanggalPesan() {
        return tanggalPesan;
    }

    public void setTanggalPesan(LocalDate tanggalPesan) {
        this.tanggalPesan = tanggalPesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean sudahBayar() {
        return sudahBayar;
    }

    public void setSudahBayar(boolean sudahBayar) {
        this.sudahBayar = sudahBayar;
    }

    public ArrayList<DetailSewa> getDaftarDetail() {
        return daftarDetail;
    }

    public ArrayList<Pengiriman> getDaftarPengiriman() {
        return daftarPengiriman;
    }

    public void tampilkan() {
        System.out.println("---- " + id + " ----");
        System.out.println("Anggota : " + (anggota != null ? anggota.getNama() : "-"));
        System.out.println("Alamat  : " + alamatTujuan);
        System.out.println("Status  : " + status);
        for (DetailSewa d : daftarDetail) {
            System.out.println("  - " + d);
        }
        System.out.println("Total sewa  : Rp" + hitungTotalSewa());
        System.out.println("Total ongkos: Rp" + hitungTotalOngkos());
    }
}
