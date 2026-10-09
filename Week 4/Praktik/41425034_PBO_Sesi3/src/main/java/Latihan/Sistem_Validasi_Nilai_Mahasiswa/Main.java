/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan.Sistem_Validasi_Nilai_Mahasiswa;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        StudentGrade  s1 = new StudentGrade();
        s1.setNIM("41425034");
        s1.setNama("Johannes");
        s1.setNilaiKuis(101);
        s1.setNilaiUTS(90);
        s1.registrasi();
        s1.validasiKuis();
        s1.setNilaiKuis(85);
        s1.validasiUTS();
        s1.gradeNilai();
        s1.KRS();
    }
}
