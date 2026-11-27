package com.mycompany.pbo_w12s2_41425034;

// Jenis mainan atau aksesoris anak. Satu item bisa punya banyak barang fisik.
public class Item {

    private String nama;
    private String bahan;
    private int usiaMin;
    private int usiaMax;
    private String deskripsi;
    private Kategori kategori;

    public Item(String nama, String bahan, int usiaMin, int usiaMax, String deskripsi, Kategori kategori) {
        this.nama = nama;
        this.bahan = bahan;
        this.usiaMin = usiaMin;
        this.usiaMax = usiaMax;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public int getUsiaMin() {
        return usiaMin;
    }

    public void setUsiaMin(int usiaMin) {
        this.usiaMin = usiaMin;
    }

    public int getUsiaMax() {
        return usiaMax;
    }

    public void setUsiaMax(int usiaMax) {
        this.usiaMax = usiaMax;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    // cek apakah item cocok untuk anak dengan usia tertentu
    public boolean cocokUntukUsia(int usia) {
        return usia >= usiaMin && usia <= usiaMax;
    }

    @Override
    public String toString() {
        return nama + " (" + (kategori != null ? kategori.getJalur() : "-") + ")";
    }
}
