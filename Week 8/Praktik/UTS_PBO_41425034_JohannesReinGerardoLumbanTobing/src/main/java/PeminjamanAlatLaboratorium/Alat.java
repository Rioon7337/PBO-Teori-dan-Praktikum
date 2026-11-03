/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeminjamanAlatLaboratorium;

/**
 *
 * @author ASUS
 */
abstract class Alat {
    private String kode;
    private String nama;
    private boolean tersedia = true;
    private int batasDaya = 90;
    private double biaya;
    
    public Alat (String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
        if ((this.kode == "" || this.nama == "") || (this.kode == " " || this.nama == " ")) {
            throw new IllegalArgumentException();
        }
    }
    
    public String getKode() {
        return kode;
    }
    
    public String getNama() {
        return nama;
    }
    
    public boolean isTersedia() {
        return tersedia;
    }
    
    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
    
    public abstract double biayaSewa(int hari);
    public abstract String jenis();
    
    public String info() {
        return kode + " - " + nama + " (" + jenis() + ") ";
    }
    
    public void AlatElektronik(String kode, String nama, int daya, int hari) {
        if(jenis() == "Elektronik" && daya >= batasDaya) {
            biaya = hari * 4000 + 1500;
        } else if(jenis() == "Elektronik") {
            biaya = hari * 4000;
        }
    }
    
    public void AlatMekanik(String kode, String nama, int hari) {
        if(jenis() == "Mekananik") {
            biaya = hari * 1500 + 500;
        }
    }
}
