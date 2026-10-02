/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassObject.Concurrency_Methods;

/**
 *
 * @author ASUS
 */

//Kode program ini error dikarenakan thread konsumen dipanggil tapi tidak pernbah ada thread konsumen
//Thread adalah unit eksekusi terkecil dalam program java.
//Setiap program java memiliki setidaknya satu thread yatu main Thread yang menbjalankan method main()
public class MainConcurrency {
    public static void main(String[] args) {
        AntreanShared antrean = new AntreanShared();
        
        //Thread Produsen
        Thread produsen = new Thread(() -> {
            String[] listPesan = {"Halo", "Belajar Java", "Selesai"};
            for (String p : listPesan) {
                antrean.kirimPesan(p); //perbaikan method bukan ambilPesan tapi kirimPesan
            }
        });
        
        //Thread konsumen
        Thread konsumen = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                antrean.ambilPesan(); 
            }
        });
        
        produsen.start();
        konsumen.start();
    }
}
