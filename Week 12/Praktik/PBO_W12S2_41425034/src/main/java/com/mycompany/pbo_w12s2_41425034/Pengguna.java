package com.mycompany.pbo_w12s2_41425034;

// Pengguna adalah kelas abstract (induknya Admin dan Anggota).
// Kelas abstract tidak bisa dibuat langsung dengan new.
public abstract class Pengguna {

    private String nama;
    private String email;
    private String noTelepon;

    public Pengguna(String nama, String email, String noTelepon) {
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
    }

    // method abstract: setiap subkelas wajib membuat isinya sendiri
    public abstract String getPeran();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    // method biasa yang dipakai bersama
    public void tampilkanInfo() {
        System.out.println(getPeran() + ": " + nama + " (" + email + ")");
    }
}
