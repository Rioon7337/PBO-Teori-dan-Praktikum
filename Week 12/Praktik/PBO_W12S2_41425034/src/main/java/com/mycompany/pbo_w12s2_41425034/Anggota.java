package com.mycompany.pbo_w12s2_41425034;

import java.util.ArrayList;
import java.util.HashMap;

// Anggota adalah subkelas dari Pengguna
public class Anggota extends Pengguna {

    // batas poin untuk tiap level (manajemen boleh mengubah angka ini)
    public static int MIN_SILVER = 100;
    public static int MIN_GOLD = 300;

    private int poin = 0;
    private int saldoRoyalti = 0;
    // nama alamat (misalnya "Rumah") disimpan bersama alamat lengkapnya
    private HashMap<String, String> daftarAlamat = new HashMap<String, String>();
    private ArrayList<Pemesanan> riwayatPesanan = new ArrayList<Pemesanan>();
    private ArrayList<String> riwayatChat = new ArrayList<String>();

    public Anggota(String nama, String email, String noTelepon) {
        super(nama, email, noTelepon);
    }

    @Override
    public String getPeran() {
        return "Anggota";
    }

    // level dihitung dari jumlah poin
    public String getLevel() {
        if (poin >= MIN_GOLD) {
            return "Gold";
        } else if (poin >= MIN_SILVER) {
            return "Silver";
        } else {
            return "Bronze";
        }
    }

    // persentase royalti sesuai level
    public int getPersenRoyalti() {
        String level = getLevel();
        if ("Gold".equalsIgnoreCase(level)) {
            return 15;
        } else if ("Silver".equalsIgnoreCase(level)) {
            return 10;
        } else {
            return 5;
        }
    }

    public void tambahPoin(int jumlah) {
        poin = poin + jumlah;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public void tambahSaldo(int jumlah) {
        saldoRoyalti = saldoRoyalti + jumlah;
    }

    public int getSaldoRoyalti() {
        return saldoRoyalti;
    }

    public void setSaldoRoyalti(int saldoRoyalti) {
        this.saldoRoyalti = saldoRoyalti;
    }

    // menambah alamat, nama alamat harus unik
    public void tambahAlamat(String namaAlamat, String alamatLengkap) {
        if (daftarAlamat.containsKey(namaAlamat)) {
            System.out.println("Nama alamat " + namaAlamat + " sudah ada");
        } else {
            daftarAlamat.put(namaAlamat, alamatLengkap);
        }
    }

    public String getAlamat(String namaAlamat) {
        return daftarAlamat.get(namaAlamat);
    }

    public HashMap<String, String> getDaftarAlamat() {
        return daftarAlamat;
    }

    public void tambahRiwayatPesanan(Pemesanan p) {
        riwayatPesanan.add(p);
    }

    public ArrayList<Pemesanan> getRiwayatPesanan() {
        return riwayatPesanan;
    }

    // mengecek apakah anggota ini sedang atau pernah menyewa barang tertentu
    public boolean pernahSewa(Barang barang) {
        if (barang == null) return false;
        for (Pemesanan p : riwayatPesanan) {
            for (DetailSewa d : p.getDaftarDetail()) {
                if (d.getBarang() != null && (d.getBarang() == barang || d.getBarang().getId() == barang.getId())) {
                    String s = d.getStatus();
                    if ("Dalam Masa Sewa".equalsIgnoreCase(s) || "Dikembalikan".equalsIgnoreCase(s)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // menyimpan pesan chat, pengirimnya bisa "Admin" atau nama anggota
    public void tambahChat(String pengirim, String isi) {
        riwayatChat.add(pengirim + ": " + isi);
    }

    public ArrayList<String> getRiwayatChat() {
        return riwayatChat;
    }

    // method ini menimpa (override) tampilkanInfo dari Pengguna
    @Override
    public void tampilkanInfo() {
        System.out.println("Anggota: " + getNama() + " | poin " + poin + " | level " + getLevel()
                + " | saldo royalti Rp" + saldoRoyalti);
    }
}
