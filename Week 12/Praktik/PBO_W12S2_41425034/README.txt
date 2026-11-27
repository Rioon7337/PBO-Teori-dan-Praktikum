============================================================
       PROGRAM SIMULASI TOYSRENT (PBO WEEK 12)
============================================================

Program ini adalah simulasi sederhana untuk layanan penyewaan 
mainan anak bernama ToysRent, dibuat menggunakan bahasa Java 
dengan konsep Pemrograman Berorientasi Objek (PBO).


1. CARA MENJALANKAN PROGRAM
------------------------------------------------------------
A. Lewat Terminal:
   1. Kompilasi kode:
      javac -d target/classes src/main/java/com/mycompany/pbo_w12s2_41425034/*.java
   2. Jalankan program:
      java -cp target/classes com.mycompany.pbo_w12s2_41425034.Main

B. Lewat NetBeans:
   - Buka folder proyek ini di NetBeans.
   - Klik tombol "Run Project" (F6), atau
   - Klik kanan pada Main.java lalu pilih "Run File".


2. PENJELASAN SEDERHANA SETIAP FILE KODE
------------------------------------------------------------
- Main.java
  Program utama yang menjalankan 13 tahapan simulasi bisnis 
  dari awal sampai akhir (kategori, sewa, bayar, kirim, retur, 
  royalti, ulasan, dll).

- PBO_W12S2_41425034.java
  Kelas pembantu pembawa nama proyek agar NetBeans bisa 
  langsung menjalankan program lewat tombol Run Project.

- Pengguna.java
  Kelas induk (abstract class) untuk semua pengguna. 
  Menyimpan data dasar: nama, email, dan nomor telepon.

- Admin.java
  Turunan dari Pengguna. Bertugas mengonfirmasi pesanan, 
  mengecek ketersediaan mainan, mengirim barang pesanan yang 
  sudah dibayar, dan memproses pengembalian barang.

- Anggota.java
  Turunan dari Pengguna (pelanggan/mitra). Memiliki poin 
  belanja, level keanggotaan (Bronze, Silver, Gold), saldo 
  royalti, daftar alamat, serta riwayat chat dengan admin.

- Kategori.java
  Mengatur kategori mainan yang bisa berjenjang (punya induk), 
  misalnya: Motorik Kasar > Rumah-Rumahan > Rumah Lego.

- Item.java
  Mewakili jenis/katalog mainan (nama, bahan, deskripsi, dan 
  rentang usia anak yang cocok).

- Barang.java
  Mewakili fisik mainan yang disewakan. Memiliki ID unik 
  otomatis, warna, status (Tersedia, Dipesan, Disewa), harga 
  sewa yang berbeda tiap level anggota, dan daftar ulasan.

- DetailSewa.java
  Mencatat satu barang di dalam pesanan, berisi lama sewa 
  (bulan), total harga sewa, tanggal mulai, dan tanggal kembali.

- Pemesanan.java
  Mencatat pesanan yang dibuat anggota. Mengatur pembayaran, 
  pemberian poin reward, pembatalan pesanan, dan perhitungan 
  total biaya sewa serta ongkos kirim.

- Pengiriman.java
  Mencatat pengiriman barang ke penyewa atau penjemputan retur. 
  Menghitung ongkos kirim dan otomatis memberikan royalti 
  ke saldo pemilik barang saat mainan titipan berhasil diterima.

- Biaya.java
  Interface sederhana untuk semua hal yang memiliki biaya 
  (dipakai oleh Pemesanan dan Pengiriman).


3. KONSEP PBO YANG DIGUNAKAN
------------------------------------------------------------
1. Pewarisan (Inheritance):
   Admin dan Anggota mewarisi atribut dari Pengguna.
2. Polimorfisme (Polymorphism):
   Objek Admin dan Anggota bisa dipanggil bersamaan lewat 
   daftar Pengguna. Begitu juga Pemesanan dan Pengiriman 
   bisa dihitung bersama lewat daftar Biaya.
3. Abstraksi (Abstraction):
   Pengguna dibuat sebagai abstract class dan Biaya dibuat 
   sebagai interface.
4. Enkapsulasi (Encapsulation):
   Semua data dibuat private dan diakses aman menggunakan 
   getter dan setter.
============================================================
