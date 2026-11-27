package com.mycompany.pbo_w12s2_41425034;

import java.time.LocalDate;
import java.util.ArrayList;

// Program utama: simulasi ToysRent dari awal sampai akhir.
// Tanggalnya dibuat tetap supaya hasilnya sama setiap kali dijalankan.
public class Main {

    public static void main(String[] args) {

        LocalDate tanggal = LocalDate.of(2026, 11, 25);

        // ---------- 1. KATEGORI ----------
        System.out.println("===== 1. KATEGORI =====");
        Kategori motorik = new Kategori("Motorik Kasar", 1, null);
        Kategori rumah = new Kategori("Rumah-Rumahan", 2, motorik);
        Kategori rumahLego = new Kategori("Rumah Lego", 3, rumah);
        Kategori halus = new Kategori("Motorik Halus", 1, null);
        Kategori puzzle = new Kategori("Puzzle Kecil", 2, halus);
        Kategori gendongan = new Kategori("Gendongan", 1, null);
        Kategori aksesoris = new Kategori("Aksesoris Bayi", 1, null);

        System.out.println(rumahLego.getJalur() + " - level " + rumahLego.getLevel());
        System.out.println(puzzle.getJalur() + " - level " + puzzle.getLevel());
        System.out.println(gendongan.getJalur() + " - level " + gendongan.getLevel());

        // ---------- 2. PENGGUNA ----------
        System.out.println("\n===== 2. PENGGUNA =====");
        Admin admin = new Admin("Rina", "rina@toysrent.id", "081100000001");
        Anggota budi = new Anggota("Budi", "budi@mail.com", "081200000002");
        Anggota sari = new Anggota("Sari", "sari@mail.com", "081200000003");
        Anggota dewi = new Anggota("Dewi", "dewi@mail.com", "081200000004");
        Anggota andi = new Anggota("Andi", "andi@mail.com", "081200000005");

        sari.tambahAlamat("Rumah", "Jl. Melati No. 10, Bandung 40111");
        dewi.tambahAlamat("Kosan", "Jl. Kenanga No. 7, Surabaya 60111");
        andi.tambahAlamat("Rumah", "Jl. Anggrek No. 2, Jakarta 10110");

        // semua pengguna disimpan dalam satu daftar
        ArrayList<Pengguna> semuaPengguna = new ArrayList<Pengguna>();
        semuaPengguna.add(admin);
        semuaPengguna.add(budi);
        semuaPengguna.add(sari);
        semuaPengguna.add(dewi);
        semuaPengguna.add(andi);

        // setiap objek menampilkan dirinya sesuai jenisnya (polymorphism)
        for (Pengguna p : semuaPengguna) {
            p.tampilkanInfo();
        }

        // ---------- 3. ITEM DAN BARANG ----------
        System.out.println("\n===== 3. ITEM DAN BARANG =====");
        Item sepeda = new Item("Sepeda Plastik", "Plastik", 2, 5, "Sepeda roda tiga", motorik);
        Item gendonganBayi = new Item("Gendongan Bayi", "Katun", 0, 1, "Gendongan untuk bayi", gendongan);
        Item puzzleLantai = new Item("Puzzle Lantai", "Busa EVA", 3, 7, "Puzzle busa", puzzle);
        Item mahkota = new Item("Mahkota Princess Merk X", "Plastik", 3, 8, "Mahkota princess", aksesoris);

        ArrayList<Item> semuaItem = new ArrayList<Item>();
        semuaItem.add(sepeda);
        semuaItem.add(gendonganBayi);
        semuaItem.add(puzzleLantai);
        semuaItem.add(mahkota);

        // barang fisik: pemilik null berarti milik ToysRent
        Barang sepeda1 = new Barang(sepeda, "Merah", "Baik", budi);
        sepeda1.setHarga(20000, 15000, 10000);
        Barang gendongan1 = new Barang(gendonganBayi, "Abu-abu", "Sangat Baik", null);
        gendongan1.setHarga(12000, 9000, 7000);
        Barang puzzle1 = new Barang(puzzleLantai, "Warna-warni", "Baik", budi);
        puzzle1.setHarga(10000, 8000, 6000);
        Barang mahkota1 = new Barang(mahkota, "Emas", "Baik", sari);
        mahkota1.setHarga(8000, 6000, 5000);

        System.out.println("Item yang cocok untuk anak usia 4 tahun:");
        for (Item it : semuaItem) {
            if (it.cocokUntukUsia(4)) {
                System.out.println("  " + it.getNama());
            }
        }

        // ---------- 4. PENITIPAN BARANG ----------
        System.out.println("\n===== 4. PENITIPAN BARANG =====");
        // setiap barang yang dititipkan memberi 50 poin
        budi.tambahPoin(50);
        System.out.println("Budi menitipkan sepeda -> poin " + budi.getPoin() + ", level " + budi.getLevel());
        budi.tambahPoin(50);
        System.out.println("Budi menitipkan puzzle -> poin " + budi.getPoin() + ", level " + budi.getLevel());
        sari.tambahPoin(50);
        System.out.println("Sari menitipkan mahkota -> poin " + sari.getPoin() + ", level " + sari.getLevel());

        // ---------- 5. PEMESANAN SARI ----------
        System.out.println("\n===== 5. PEMESANAN SARI =====");
        Pemesanan p1 = new Pemesanan(sari, "Rumah", tanggal);
        p1.tambahBarang(gendongan1, 4);   // 4 bulan
        p1.tambahBarang(sepeda1, 2);      // 2 bulan
        p1.tampilkan();

        admin.konfirmasiPesanan(p1);
        System.out.println("Status setelah dikonfirmasi: " + p1.getStatus());

        p1.bayar();
        System.out.println("Poin Sari sekarang: " + sari.getPoin() + ", level " + sari.getLevel());

        // barang dikirim ke alamat Sari
        Pengiriman kirim1 = admin.kirimBarang(p1, "DIKIRIM_KE_ALAMAT", tanggal.plusDays(1));
        kirim1.tampilkan();

        // barang sampai dua hari kemudian, masa sewa mulai dihitung
        kirim1.tandaiDiterima(tanggal.plusDays(2));
        p1.updateStatus();
        p1.tampilkan();

        // ---------- 6. PEMESANAN DEWI ----------
        System.out.println("\n===== 6. PEMESANAN DEWI =====");
        Pemesanan p2 = new Pemesanan(dewi, "Kosan", tanggal.plusDays(2));
        p2.tambahBarang(sepeda1, 2);
        p2.tambahBarang(mahkota1, 1);

        // sepeda masih disewa Sari, jadi tidak tersedia. Mahkota tersedia.
        admin.konfirmasiPesanan(p2);
        p2.tampilkan();

        System.out.println("Chat untuk Dewi:");
        for (String pesan : dewi.getRiwayatChat()) {
            System.out.println("  " + pesan);
        }

        // Dewi memilih menunggu sepeda, jadi pesanannya tidak dibatalkan
        p2.bayar();
        Pengiriman kirim2 = admin.kirimBarang(p2, "AMBIL_DI_GUDANG", tanggal.plusDays(3));
        kirim2.tampilkan();
        kirim2.tandaiDiterima(tanggal.plusDays(3));
        p2.updateStatus();

        // ---------- 7. PENGEMBALIAN ----------
        System.out.println("\n===== 7. PENGEMBALIAN =====");
        // mahkota Dewi habis masa sewanya pada 28 Desember 2026
        Pengiriman ret2 = admin.prosesPengembalian(p2, LocalDate.of(2026, 12, 28), "KEMBALI_KE_GUDANG");
        ret2.tampilkan();

        // sepeda Sari habis masa sewanya pada 27 Januari 2027
        Pengiriman ret1 = admin.prosesPengembalian(p1, LocalDate.of(2027, 1, 27), "DIJEMPUT_DI_ALAMAT");
        ret1.tampilkan();
        System.out.println("Status sepeda sekarang: " + sepeda1.getStatus());

        // ---------- 8. KONFIRMASI ULANG DEWI ----------
        System.out.println("\n===== 8. KONFIRMASI ULANG PESANAN DEWI =====");
        admin.konfirmasiPesanan(p2);  // sepeda sekarang sudah tersedia
        Pengiriman kirim3 = admin.kirimBarang(p2, "DIKIRIM_KE_ALAMAT", LocalDate.of(2027, 1, 28));
        kirim3.tampilkan();
        kirim3.tandaiDiterima(LocalDate.of(2027, 1, 29));
        p2.updateStatus();
        p2.tampilkan();

        // ---------- 9. PEMBATALAN ----------
        System.out.println("\n===== 9. PEMBATALAN ANDI =====");
        Pemesanan p3 = new Pemesanan(andi, "Rumah", tanggal.plusDays(3));
        p3.tambahBarang(puzzle1, 1);
        admin.konfirmasiPesanan(p3);
        System.out.println("Status sebelum dibatalkan: " + p3.getStatus());
        p3.batalkan();
        System.out.println("Status setelah dibatalkan: " + p3.getStatus());
        System.out.println("Status puzzle sekarang: " + puzzle1.getStatus());

        // ---------- 10. REVIEW ----------
        System.out.println("\n===== 10. REVIEW =====");
        sepeda1.tambahReview(sari, "Sepeda kuat dan nyaman");          // Sari pernah menyewa, diterima
        puzzle1.tambahReview(budi, "Mau review barang sendiri");        // Budi belum pernah menyewa, ditolak
        System.out.println("Review sepeda: " + sepeda1.getDaftarReview());

        // ---------- 11. CHAT ----------
        System.out.println("\n===== 11. CHAT SARI DAN ADMIN =====");
        sari.tambahChat("Sari", "Apakah pengiriman bisa pagi hari?");
        sari.tambahChat("Admin", "Bisa, kami usahakan pagi hari.");
        for (String pesan : sari.getRiwayatChat()) {
            System.out.println("  " + pesan);
        }

        // ---------- 12. UBAH BATAS LEVEL ----------
        System.out.println("\n===== 12. UBAH BATAS LEVEL =====");
        System.out.println("Level Sari sekarang: " + sari.getLevel() + " (poin " + sari.getPoin() + ")");
        Anggota.MIN_SILVER = 80;  // manajemen menurunkan syarat Silver
        System.out.println("Setelah syarat Silver jadi 80, level Sari: " + sari.getLevel());

        // ---------- 13. RINGKASAN ----------
        System.out.println("\n===== 13. RINGKASAN =====");
        for (Pengguna p : semuaPengguna) {
            p.tampilkanInfo();
        }
        System.out.println("Saldo royalti Budi: Rp" + budi.getSaldoRoyalti());
        System.out.println("Saldo royalti Sari: Rp" + sari.getSaldoRoyalti());

        // semua yang punya biaya (pesanan dan pengiriman) dimasukkan ke satu daftar
        ArrayList<Biaya> semuaBiaya = new ArrayList<Biaya>();
        semuaBiaya.add(p1);
        semuaBiaya.add(p2);
        semuaBiaya.add(kirim1);
        semuaBiaya.add(ret1);
        for (Biaya b : semuaBiaya) {
            System.out.println(b.getKeterangan() + " -> total Rp" + b.hitungTotal());
        }
    }
}
