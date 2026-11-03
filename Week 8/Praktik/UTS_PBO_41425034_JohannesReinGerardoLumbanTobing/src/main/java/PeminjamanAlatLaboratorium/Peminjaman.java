/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PeminjamanAlatLaboratorium;

/**
 *
 * @author ASUS
 */
public class Peminjaman {
    public static final int MAX_HARI = 4;
    
    public double pinjam (Anggota a, Alat t, int hari) throws PinjamException{
        if(hari <= 0 || hari > MAX_HARI) {
            throw new PinjamException("Durasi tidak valid");
        } else if(t.isTersedia() == false) {
            throw new PinjamException("Alat tidak tersedia");
        } 
    }
}
