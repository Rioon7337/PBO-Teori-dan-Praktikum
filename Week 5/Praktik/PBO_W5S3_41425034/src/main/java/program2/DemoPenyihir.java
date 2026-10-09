package program2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/

import java.util.*;

/*
1. Saat kita menghapus @Override pada code editing area tidak nampak ada error, 
namun saat kita melakukan running terhadap main maka sistem memberikan Compilation Error
dikarenakan class HarryPotter yang sebagai subclass Penyihir menggunakan method parent
ucapkanMantra dengan isi yang berbeda dari superclass sehingga ini akan membuat sistem 
error karena terdapat method dengan nama yang sama.
2. Jika menggunakan polymoorphism seperti ini maka kita akan dapat membuat suatu class
khusus yang meiliki method yang sama namun memiliki isi method yang berbeda. Selain itu, 
kita juga dimudahkan karena kita tidak butuh membuat banyak method untuk satu class khusus.
*/

class Penyihir {
    public void ucapkanMantra() {
        System.out.println("Mengucapkan mantra dengan cara biasa.");
    }
}

class HarryPotter extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Harry Potter mengucapkan mantra dengan tongkatnya yang unik.");
    }
}

class Hermione extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Hermione mengucapkan mantra dengan tepat dan percaya diri.");
    }
}

class RonWeasley extends Penyihir {
    @Override
    public void ucapkanMantra() {
        System.out.println("Ron Weasley mengucapkan mantra dengan konyol.");
    }
}

public class DemoPenyihir {
    public static void main(String[] args) {
        Penyihir penyihir1 = new HarryPotter();
        Penyihir penyihir2 = new Hermione();
        Penyihir penyihir3 = new RonWeasley();

        penyihir1.ucapkanMantra();
        penyihir2.ucapkanMantra();
        penyihir3.ucapkanMantra();
    }
}
