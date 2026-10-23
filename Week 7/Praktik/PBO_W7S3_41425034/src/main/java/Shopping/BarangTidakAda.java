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

//Error Custom yang dibuat untuk menangani ketika barang yang dicari tidak ada
public class BarangTidakAda extends Exception{
    public BarangTidakAda(String message) {
        super(message);
    }
}
