/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeminjamanAlatLaboratorium;

/**
 *
 * @author ASUS
 */
public class AlatMekanik extends Alat {
    public AlatMekanik(String kode, String nama) {
        super(kode, nama);
    }
    @Override
    public double biayaSewa(int hari) {
        return hari * 1500 + 500;
    }
    
    @Override
    public String jenis() {
        return "Elektronik";
    }
}
