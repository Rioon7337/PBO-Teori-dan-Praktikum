/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.del.test;

/**
 *
 * @author ASUS
 */

import id.ac.del.rental.VehicleRental; 

public class TestRental {
    public static void main(String[] args) { 
        VehicleRental v = new VehicleRental("BK 1234 DEL", 250000); 
        // Baris A 
        v.plateNumber = ""; 
        // Baris B 
        v.rentalRatePerDay = -500000; 
        // Baris C 
        v.discountRate = 0.20; 
        // Baris D 
        v.setRentalDays(-7); 
        System.out.println("Total Biaya: Rp" + v.getTotalCost()); 
    } 
}

/*
1. Baris yang menyebabkan error adalah baris B dan C. Hal ini dikarenakan sifat dari
protected tidak sama seperti public yang dapat diakses oleh semuanya, protected tidak dapat 
digunakan oleh class lain dipackage yang berbeda jika tidak merupakan subclassnya.
2. i) Pada baris D yang memanggil method setter tidak menyertakan validsi data yang 
menyebabkan data yang dimasukkan dapat berupa negatif.
ii) Total biaya dapat bernilai negatif apabila salah satu variabel datanya bernilai negatif
seperti yang dilakukan pada data yang dimasukkan ke method setRentalDay, hal ini dapat 
dicegah dengan membuat valiadasi input pada method yang ada.
3. i) public interface Discountable {
            public void calculateDiscount(double amount);
      }
ii) public void calculateDiscount(double amount) {
        totalDiscount = rentalRatePerDay * rentalDays * amount;
    }

    public double getTotalCost() { 
        return (rentalRatePerDay * rentalDays) - totalDiscount; 
    }
*/
