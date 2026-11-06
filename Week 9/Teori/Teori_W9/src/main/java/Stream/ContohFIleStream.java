/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stream;

/**
 *
 * @author ASUS
 */
// ============================================================
// Program : ContohFileStream
// Tujuan  : Mempelajari cara menggunakan FileOutputStream dan
//           FileInputStream untuk menulis, membaca, dan menyalin file.
// ============================================================

// Import class-class yang dibutuhkan dari package java.io
import java.io.FileInputStream;        // Untuk membaca file (input)
import java.io.FileOutputStream;       // Untuk menulis file (output)
import java.io.FileNotFoundException;  // Exception jika file tidak ditemukan
import java.io.IOException;            // Exception umum untuk operasi input/output

public class ContohFIleStream {

    // Method main: titik awal program dijalankan
    public static void main(String[] args) {

        // Nama file sumber (yang akan ditulis lalu dibaca)
        String fileSumber = "data_asli.txt";

        // Nama file tujuan (hasil salinan dari fileSumber)
        String fileTujuan = "data_salinan.txt";

        // Teks yang akan ditulis ke dalam file
        // \n adalah karakter untuk pindah baris
        String teks = "Halo! Ini adalah contoh penggunaan FileOutputStream.\n"
                    + "Baris kedua berisi contoh FileInputStream.";

        // LANGKAH 1: Menulis teks ke file menggunakan FileOutputStream
        tulisFile(fileSumber, teks);

        // LANGKAH 2: Membaca isi file menggunakan FileInputStream
        bacaFile(fileSumber);

        // LANGKAH 3: Menyalin file menggunakan FileInputStream dan FileOutputStream
        salinFile(fileSumber, fileTujuan);

        // LANGKAH 4: Membaca file hasil salinan untuk membuktikan isinya sama
        bacaFile(fileTujuan);
    }

    // ------------------------------------------------------------
    // METHOD 1: Menulis teks ke file dengan FileOutputStream
    // ------------------------------------------------------------
    public static void tulisFile(String namaFile, String isi) {

        // try-with-resources:
        // FileOutputStream dibuka di dalam tanda kurung try.
        // Setelah blok try selesai (berhasil atau error), stream
        // ditutup OTOMATIS. Ini penting agar file tidak terkunci.
        //
        // new FileOutputStream(namaFile) membuat file baru.
        // Jika file sudah ada, isinya akan DITIMPA (dihapus dulu).
        try (FileOutputStream fos = new FileOutputStream(namaFile)) {

            // FileOutputStream hanya bisa menulis data dalam bentuk BYTE.
            // Karena isinya berupa String, kita ubah dulu menjadi array byte
            // menggunakan method getBytes().
            byte[] dataByte = isi.getBytes();

            // write(byte[]) menulis SELURUH isi array byte ke file
            fos.write(dataByte);

            System.out.println("Berhasil menulis ke file: " + namaFile);

        } catch (IOException e) {
            // Jika terjadi error saat menulis (misalnya tidak ada izin akses),
            // program tidak langsung berhenti. Pesan error ditampilkan di sini.
            System.out.println("Gagal menulis file: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // METHOD 2: Membaca isi file dengan FileInputStream
    // ------------------------------------------------------------
    public static void bacaFile(String namaFile) {

        // FileInputStream dibuka dengan try-with-resources,
        // jadi akan ditutup otomatis setelah selesai dipakai.
        try (FileInputStream fis = new FileInputStream(namaFile)) {

            System.out.println("\nIsi file " + namaFile + ":");
            System.out.println("-----------------------------");

            int dataByte;   // Variabel untuk menyimpan satu byte yang dibaca

            // read() membaca SATU byte dari file setiap kali dipanggil.
            // Hasilnya berupa int (nilai 0 sampai 255).
            // Jika sudah sampai akhir file (End Of File), read() mengembalikan -1.
            // Perulangan berjalan selama nilainya belum -1.
            while ((dataByte = fis.read()) != -1) {

                // Ubah byte (int) menjadi char agar bisa dibaca manusia,
                // lalu tampilkan. print() tanpa "ln" tidak pindah baris.
                System.out.print((char) dataByte);
            }

            System.out.println("\n-----------------------------");

        } catch (FileNotFoundException e) {
            // Exception khusus jika file yang dicari tidak ada
            System.out.println("File tidak ditemukan: " + namaFile);

        } catch (IOException e) {
            // Exception umum untuk error lain saat membaca
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // METHOD 3: Menyalin file dengan FileInputStream + FileOutputStream
    // ------------------------------------------------------------
    public static void salinFile(String fileSumber, String fileTujuan) {

        // Buffer adalah "wadah sementara" berukuran 8192 byte (8 KB).
        // Membaca dan menulis per blok jauh lebih cepat daripada
        // satu byte per satu byte, terutama untuk file yang besar.
        byte[] buffer = new byte[8192];

        // Membuka DUA stream sekaligus:
        // - fis : untuk membaca file sumber
        // - fos : untuk menulis file tujuan
        // Keduanya otomatis ditutup di akhir blok try.
        try (FileInputStream fis = new FileInputStream(fileSumber);
             FileOutputStream fos = new FileOutputStream(fileTujuan)) {

            int jumlahByteTerbaca;   // Menyimpan jumlah byte yang berhasil dibaca

            // read(buffer) mengisi buffer dengan data dari file sumber,
            // lalu mengembalikan jumlah byte yang benar-benar terisi.
            // Jika data sudah habis, mengembalikan -1.
            while ((jumlahByteTerbaca = fis.read(buffer)) != -1) {

                // write(buffer, offset, length) menulis data dari buffer:
                // - buffer            : sumber data
                // - 0                 : mulai dari indeks ke-0
                // - jumlahByteTerbaca : hanya sebanyak byte yang terbaca
                // Ini penting agar byte kosong sisa buffer tidak ikut tertulis.
                fos.write(buffer, 0, jumlahByteTerbaca);
            }

            System.out.println("\nFile berhasil disalin dari " + fileSumber
                               + " ke " + fileTujuan);

        } catch (FileNotFoundException e) {
            System.out.println("File sumber tidak ditemukan: " + fileSumber);

        } catch (IOException e) {
            System.out.println("Gagal menyalin file: " + e.getMessage());
        }
    }
}
