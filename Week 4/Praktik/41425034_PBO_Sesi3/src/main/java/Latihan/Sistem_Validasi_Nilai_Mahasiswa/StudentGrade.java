/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan.Sistem_Validasi_Nilai_Mahasiswa;

/**
 *
 * @author ASUS
 */
public class StudentGrade {
    private String Nim;
    private String nama;
    private double nilaiKuis;
    private double nilaiUTS;
    private double total;
    
    public String getNIM() {
        return this.Nim;
    }
    
    public void setNIM(String Nim) {
        this.Nim =  Nim;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public double getNilaiKuis() {
        return this.nilaiKuis;
    }
    
    public void setNilaiKuis(int nilaiKuis) {
        this.nilaiKuis = nilaiKuis;
    }
    
    public double getNilaiUTS() {
        return this.nilaiUTS;
    }
    
    public void setNilaiUTS(int nilaiUTS) {
        this.nilaiUTS = nilaiUTS;
    }
    
    public void validasiKuis() {
        if(this.nilaiKuis < 0 || this.nilaiKuis > 100) {
            System.out.println("[Error] Nilai Kuis tidak valid: " + this.nilaiKuis
                                + "(Harus anatara 0 - 100)");
        } else {
            System.out.println("[UPDATE] Nilai Kuis berhasil diubah menjadi: "
                                + this.nilaiKuis);
        }
    }
    
    public void validasiUTS() {
        if(this.nilaiUTS < 0 || this.nilaiUTS > 100) {
            System.out.println("[Error] Nilai UTS tidak valid: " + this.nilaiUTS
                                + "(Harus anatara 0 - 100)");
        } else {
            System.out.println("[UPDATE] Nilai UTS berhasil diubah menjadi: "
                                + this.nilaiUTS);
        }
    }
    
    public double gradeNilai() {
        total = (this.nilaiKuis * 0.4) + (this.nilaiUTS * 0.6);
        return total;
    }
    
    public void registrasi() {
        System.out.println("[REGISTRASI] Berhasil mendaftarkan mhasiswa: " 
                            + this.Nim + " - " + this.nama);
    }
    
    public void KRS() {
        System.out.println("=== KARTU HASIL STUDI ===");
        System.out.println("NIM             : " + this.Nim);
        System.out.println("Nama            : " + this.nama);
        System.out.println("Nilai Kuis      : " + this.nilaiKuis);
        System.out.println("Nilai UTS       : " + this.nilaiUTS);
        System.out.println("Nilai  Akhir    : " + this.total);
    }
}
