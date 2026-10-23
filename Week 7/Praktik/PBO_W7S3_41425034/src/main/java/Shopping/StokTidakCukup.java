/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shopping;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

//Error custom yang dibuat untuk menangani ketika jumlah barang yang ingin dibeli
//lebih banyak dari stok yang ada
public class StokTidakCukup extends Exception{
    public StokTidakCukup(String message) {
        super(message);
    }
}
