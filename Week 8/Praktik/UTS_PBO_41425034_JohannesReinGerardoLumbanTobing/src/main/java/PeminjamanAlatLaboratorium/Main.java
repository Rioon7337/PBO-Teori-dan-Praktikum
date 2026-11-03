/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package PeminjamanAlatLaboratorium;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("-----  TAHAP 1 -----");
            Anggota objk1 = new Anggota("034", "Johannes", 3);
            System.out.println("E1 - Multimeter (Elektronik)");
            System.out.println("M1 - Obeng (Mekanik)");
            objk1.hitungPeminjamanElektronik(1);
            objk1.hitungPeminjamanMekanik(3);
            System.out.println(objk1.bisaMeminjam());
            
            System.out.println("-----  TAHAP 2 -----");
            Alat objk2 = new AlatElektronik("E1", "Multimeter");
            Alat objk3 = new AlatMekanik("M1", "Obeng");
            Alat objk4 = new AlatElektronik("E2", "Osiloskop");
            System.out.println(objk2.info() + " -> " + objk2.biayaSewa(1) + " | Servis " 
                    + objk2.getNama() + " tiap 30 hari.");
            System.out.println(objk3.info() + objk3.biayaSewa(1));
            System.out.println(objk4.info() + " -> " + objk4.biayaSewa(1) + " | Servis " 
                    + objk4.getNama() + " tiap 30 hari.");
            
            System.out.println("-----  TAHAP 3 -----");
            Alat[] daftarAlat = new Alat[4];
            daftarAlat[0] = new AlatElektronik("E1", "Multimeter");
            daftarAlat[1] = new AlatMekanik("M1", "Obeng");
            daftarAlat[2] = new AlatElektronik("E2", "Osiloskop");
            daftarAlat[3] = new AlatMekanik("M2", "Tang");
            Anggota pinjam = new Anggota("034", "Johannes", 3);
            if(daftarAlat[0].biayaSewa(5) > daftarAlat[0].biayaSewa(4)) {
                System.out.println("Gagal: Durasi tidak valid");
            }
            daftarAlat[1].setTersedia(false);
            if(daftarAlat[1].isTersedia() != true) {
                System.out.println("Gagal: Alat tidak tersedia");
            }
            for(int i = 0; i < 3; i++) {
                pinjam.catatPinjam();
            }
            if(pinjam.getJumlahPinjam() == pinjam.getMaxPinjam()) {
                System.out.println("Gagal: Kuota Habis");
            }
            System.out.println(daftarAlat[3].getKode() + " tersedia? " + daftarAlat[3].isTersedia());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: terdapat data yang tidak sesuai.");
        }
        
        
    }
}
