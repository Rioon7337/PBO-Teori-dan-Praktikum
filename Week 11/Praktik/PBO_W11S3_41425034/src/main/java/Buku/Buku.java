/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buku;

/**
 *
 * @author ASUS
 */
public class Buku {
    private String judul;
    private String status = "tersedia";
    private String idPeminjam;
    
    public Buku(String judul) {
        this.judul = judul;
    }
    
    public String getJudul() {
        return this.judul;
    }
    
    public synchronized String getStatus() {
        return this.status;
    }
    
    public synchronized String getIdPeminjam() {
        return this.idPeminjam;
    }
    
    public synchronized void pinjamBuku(String judul, String idPeminjam) {
        if(status.equals("tersedia")) {
            this.idPeminjam = idPeminjam;
            status = "dipinjam";
            System.out.println("Pemminjaman Buku " + this.getJudul() + " telah berhasil dilakukan oleh pengunjung ber-id (" + this.getIdPeminjam() + ") ");
        } else {
            System.out.println("Maaf, pengunjung ber-id " + idPeminjam + " buku yang anda minta sedang dipinjam oleh pengunjung ber-id (" + this.getIdPeminjam() + ").");
        }
    }
    
    public synchronized void kembalikanBuku(String judul, String idPeminjam) {
        if(status.equals("dipinjam") && idPeminjam.equals(this.idPeminjam)) {
            this.idPeminjam = null;
            status = "tersedia";
            System.out.println("Pengembalian buku berhasil dilakukan");
        } else if(status.equals("dipinjam") && !idPeminjam.equals(this.idPeminjam)) {
            System.out.println("Maaf, idPeminjam tidak pernah meminjam buku tersebut");
        } else if(!status.equals("dipinjam") && idPeminjam.equals(this.idPeminjam)) {
            System.out.println("Nama buku yang diberikan tidak dapat ditemukan");
        } else {
            System.out.println("Maaf, buku sedang tidak dipinjam.");
        }
    }
}
