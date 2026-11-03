package minggu1;

public class MainMinggu1 {
    public static void main(String[] args) {
        System.out.println("=== PROGRAM UTAMA MINGGU 1 ===");

        Mahasiswa m1 = new Mahasiswa();
        m1.nama = "Rina";
        m1.semester = 1;
        m1.perkenalan();

        Mahasiswa m2 = new Mahasiswa();
        m2.nama = "Budi";
        m2.semester = 3;
        m2.perkenalan();
    }
}