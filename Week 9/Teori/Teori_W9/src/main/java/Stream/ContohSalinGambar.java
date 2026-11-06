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
// Program : ContohSalinGambar
// Tujuan  : Menyalin file gambar (JPG, PNG, GIF, dll) menggunakan
//           FileInputStream dan FileOutputStream.
// ============================================================

// Import class-class yang dibutuhkan
import java.io.File;                  // Untuk mengecek informasi file (ada/tidak, ukuran)
import java.io.FileInputStream;       // Untuk membaca file (input)
import java.io.FileOutputStream;      // Untuk menulis file (output)
import java.io.FileNotFoundException; // Exception jika file tidak ditemukan
import java.io.IOException;           // Exception umum untuk operasi input/output

public class ContohSalinGambar {

    // Method main: titik awal program dijalankan
    public static void main(String[] args) {

        // Nama file gambar sumber.
        // File ini harus ada di folder yang sama dengan program.
        // Bisa juga pakai path lengkap, misalnya "C:/Users/Nama/Pictures/foto.jpg"
        String fileGambarAsli = "gambar.jpeg";

        // Nama file hasil salinan.
        // Ekstensi (.jpg) sebaiknya sama dengan format aslinya
        // agar bisa dibuka oleh aplikasi penampil gambar.
        String fileGambarSalinan = "gambar_salinan.jpeg";

        // LANGKAH 1: Tampilkan informasi file asli
        System.out.println("=== INFORMASI FILE ASLI ===");
        tampilkanInfoFile(fileGambarAsli);
        tampilkanHeaderByte(fileGambarAsli);

        // LANGKAH 2: Salin gambar dari file asli ke file salinan
        System.out.println("\n=== PROSES MENYALIN ===");
        salinGambar(fileGambarAsli, fileGambarSalinan);

        // LANGKAH 3: Tampilkan informasi file salinan untuk dibandingkan
        System.out.println("\n=== INFORMASI FILE SALINAN ===");
        tampilkanInfoFile(fileGambarSalinan);
        tampilkanHeaderByte(fileGambarSalinan);
    }

    // ------------------------------------------------------------
    // METHOD 1: Menyalin gambar dengan FileInputStream + FileOutputStream
    // ------------------------------------------------------------
    public static void salinGambar(String fileSumber, String fileTujuan) {

        // Buffer adalah wadah sementara berukuran 8192 byte (8 KB).
        // Data gambar dipindahkan per blok, bukan satu byte per satu byte.
        // Cara ini jauh lebih cepat, apalagi untuk gambar berukuran besar.
        byte[] buffer = new byte[8192];

        // try-with-resources: kedua stream dibuka di sini dan
        // ditutup OTOMATIS saat blok try selesai, baik berhasil maupun error.
        // - fis: membaca gambar asli
        // - fos: menulis gambar salinan
        try (FileInputStream fis = new FileInputStream(fileSumber);
             FileOutputStream fos = new FileOutputStream(fileTujuan)) {

            // Variabel untuk menyimpan jumlah byte yang terbaca pada setiap putaran
            int jumlahByteTerbaca;

            // read(buffer) mengisi buffer dengan data dari gambar asli.
            // Method ini mengembalikan jumlah byte yang benar-benar terisi.
            // Jika seluruh file sudah terbaca, mengembalikan -1 dan perulangan berhenti.
            while ((jumlahByteTerbaca = fis.read(buffer)) != -1) {

                // write(buffer, 0, jumlahByteTerbaca) menulis data ke file salinan:
                // - buffer            : sumber data
                // - 0                 : mulai dari indeks ke-0
                // - jumlahByteTerbaca : hanya sebanyak byte yang terbaca
                // Ini penting agar sisa buffer yang kosong tidak ikut tertulis.
                fos.write(buffer, 0, jumlahByteTerbaca);
            }

            System.out.println("Gambar berhasil disalin ke: " + fileTujuan);

        } catch (FileNotFoundException e) {
            // Terjadi jika file gambar sumber tidak ditemukan
            System.out.println("File gambar tidak ditemukan: " + fileSumber);

        } catch (IOException e) {
            // Error umum saat membaca atau menulis (misalnya disk penuh)
            System.out.println("Gagal menyalin gambar: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // METHOD 2: Menampilkan nama dan ukuran file
    // ------------------------------------------------------------
    public static void tampilkanInfoFile(String namaFile) {

        // Class File digunakan untuk mengambil informasi file,
        // bukan untuk membaca isinya
        File file = new File(namaFile);

        // exists() mengecek apakah file tersebut ada
        if (file.exists()) {
            System.out.println("File   : " + namaFile);

            // length() mengembalikan ukuran file dalam satuan byte
            System.out.println("Ukuran : " + file.length() + " byte");
        } else {
            System.out.println("File tidak ditemukan: " + namaFile);
        }
    }

    // ------------------------------------------------------------
    // METHOD 3: Menampilkan 10 byte pertama file dalam format heksadesimal
    // ------------------------------------------------------------
    // Setiap format gambar memiliki "tanda" di awal file (disebut file header/signature).
    // Contohnya, JPG diawali FF D8 FF, dan PNG diawali 89 50 4E 47.
    // Method ini memperlihatkan bahwa gambar memang hanya kumpulan byte.
    public static void tampilkanHeaderByte(String namaFile) {

        try (FileInputStream fis = new FileInputStream(namaFile)) {

            System.out.print("10 byte pertama (heksadesimal): ");

            // Membaca 10 byte pertama, satu per satu
            for (int i = 0; i < 10; i++) {

                // read() mengembalikan nilai 0 sampai 255, atau -1 jika file sudah habis
                int nilaiByte = fis.read();

                if (nilaiByte == -1) {
                    break; // File lebih pendek dari 10 byte, hentikan perulangan
                }

                // %02X menampilkan angka dalam heksadesimal dengan minimal 2 digit
                // Contoh: 255 ditampilkan sebagai FF, 8 ditampilkan sebagai 08
                System.out.printf("%02X ", nilaiByte);
            }

            System.out.println(); // Pindah baris setelah semua byte ditampilkan

        } catch (IOException e) {
            System.out.println("Gagal membaca header file: " + e.getMessage());
        }
    }
}
