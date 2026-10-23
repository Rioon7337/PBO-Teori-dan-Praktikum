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

//Error custom yang dibuat untuk menangani keadaan saat barang yang dicari stoknya habis atau hanya tinggal 1
public class StokKosong extends Exception{
    public StokKosong(String message) {
        super(message);
    }
}
