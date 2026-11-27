package com.mycompany.pbo_w12s2_41425034;

import java.util.ArrayList;

// Satu barang fisik. Setiap barang punya ID sendiri (otomatis),
// dan harga sewanya berbeda untuk tiap level anggota.
public class Barang {

    // penghitung untuk ID otomatis
    private static int nomorTerakhir = 0;

    private int id;
    private Item item;
    private String warna;
    private String kondisi;
    private Anggota pemilik;        // null berarti milik ToysRent
    private String status;          // Tersedia, Dipesan, atau Disewa
    private int hargaBronze;
    private int hargaSilver;
    private int hargaGold;
    private ArrayList<String> daftarReview = new ArrayList<String>();

    public Barang(Item item, String warna, String kondisi, Anggota pemilik) {
        nomorTerakhir++;
        this.id = nomorTerakhir;
        this.item = item;
        this.warna = warna;
        this.kondisi = kondisi;
        this.pemilik = pemilik;
        this.status = "Tersedia";
    }

    // mengisi harga sewa per pekan untuk tiap level
    public void setHarga(int bronze, int silver, int gold) {
        this.hargaBronze = bronze;
        this.hargaSilver = silver;
        this.hargaGold = gold;
    }

    public int getHargaPerPekan(String level) {
        if ("Gold".equalsIgnoreCase(level)) {
            return hargaGold;
        } else if ("Silver".equalsIgnoreCase(level)) {
            return hargaSilver;
        } else {
            return hargaBronze;
        }
    }

    public int getHargaBronze() {
        return hargaBronze;
    }

    public int getHargaSilver() {
        return hargaSilver;
    }

    public int getHargaGold() {
        return hargaGold;
    }

    // review hanya boleh dari anggota yang pernah menyewa barang ini
    public void tambahReview(Anggota orang, String isi) {
        if (orang == null || !orang.pernahSewa(this)) {
            String namaOrang = (orang != null) ? orang.getNama() : "Pengguna";
            System.out.println("Review ditolak, " + namaOrang + " belum pernah menyewa " + this);
            return;
        }
        daftarReview.add(orang.getNama() + ": " + isi);
    }

    public ArrayList<String> getDaftarReview() {
        return daftarReview;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getNamaItem() {
        return item != null ? item.getNama() : "";
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public Anggota getPemilik() {
        return pemilik;
    }

    public void setPemilik(Anggota pemilik) {
        this.pemilik = pemilik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String nama = (item != null) ? item.getNama() : "Item";
        return "#" + id + " " + nama + " (" + warna + ")";
    }
}
