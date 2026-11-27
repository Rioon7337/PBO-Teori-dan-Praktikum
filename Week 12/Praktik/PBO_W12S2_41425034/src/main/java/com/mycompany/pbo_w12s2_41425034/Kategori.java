package com.mycompany.pbo_w12s2_41425034;

// Kategori item, bisa punya induk (kategori di atasnya)
public class Kategori {

    private String nama;
    private int level;
    private Kategori induk; // null kalau ini kategori utama

    public Kategori(String nama, int level, Kategori induk) {
        this.nama = nama;
        this.level = level;
        this.induk = induk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Kategori getInduk() {
        return induk;
    }

    public void setInduk(Kategori induk) {
        this.induk = induk;
    }

    // jalur lengkap, misalnya "Motorik Kasar > Rumah-Rumahan"
    public String getJalur() {
        if (induk == null) {
            return nama;
        }
        return induk.getJalur() + " > " + nama;
    }
}
