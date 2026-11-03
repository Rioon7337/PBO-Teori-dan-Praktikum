/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeminjamanAlatLaboratorium;

/*
tarifE/hari = 4000
tarifM/hari = 1500
MAX_HARI = 4
Kuota anggota = 3
Batas daya = 90
surE = 1500
fixm = 500
IntervalServis = 35
DAYA1 = 90
DAYA2 = 89
*/
public class Anggota {
    private String nim;
    private String nama;
    private int maxPinjam;
    private int jumlahPinjam = 0;
    
    Anggota(String nim, String nama, int maxPinjam) {
        this.nim = nim;
        this.nama = nama;
        this.maxPinjam = maxPinjam;
        if ((this.nim == "" || this.nama == "" || this.maxPinjam <= 0) || (this.nim == " " || this.nama == " ")) {
            throw new IllegalArgumentException();
        }
    }
    
    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getMaxPinjam() {
        return maxPinjam;
    }
    
    public int getJumlahPinjam() {
        return jumlahPinjam;
    }
    
    public boolean bisaMeminjam() {
        boolean bisa = false;
        if (jumlahPinjam < maxPinjam) {
            bisa = true;
        }
        return bisa;
    }
    
    public void catatPinjam() {
        jumlahPinjam += 1;
    }
    
    public void hitungPeminjamanElektronik(int hari) {
        System.out.println("Elektronik " + hari + " hari: " + hari * 4000);
        catatPinjam();
    }
    
    public void hitungPeminjamanMekanik(int hari) {
        System.out.println("Mekanik " + hari + " hari: " + hari * 1500);
        catatPinjam();
    }
}
