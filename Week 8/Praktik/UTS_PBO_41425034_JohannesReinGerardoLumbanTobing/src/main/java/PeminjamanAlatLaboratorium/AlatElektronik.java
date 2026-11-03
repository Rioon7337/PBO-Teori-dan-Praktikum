/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeminjamanAlatLaboratorium;

/**
 *
 * @author ASUS
 */
public class AlatElektronik extends Alat implements Dapatdiservis{
    public AlatElektronik(String kode, String nama) {
        super(kode, nama);
    }
    @Override
    public double biayaSewa(int hari) {
        return hari * 4000; 
    }
    
    @Override
    public String jenis() {
        return "Elektronik";
    }
    
    @Override 
    public int intervalHari() {
        return 35;
    }
    
    @Override
    public String servis() {
        return "Servis " + getNama();
    }
}
