/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tantangan;

import java.util.ArrayList;
import java.util.List;

/*
Nama    : Johannes Rein Gerardo Lumban Tobing
NIM     : 41425034
Prodi   : D4 TRPL
*/
abstract class MantraPerlindungan {
    private String nama;

    public MantraPerlindungan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void aktifkan();

    public abstract void nonaktifkan();
}

class Protego extends MantraPerlindungan {
    public Protego() {
        super("Protego");
    }

    @Override
    public void aktifkan() {
        System.out.println("Perisai Protego terbentuk!");
    }

    @Override
    public void nonaktifkan() {
        System.out.println("Perisai Protego menghilang.");
    }
}

class Fidelius extends MantraPerlindungan {
    private String secretKeeper;

    public Fidelius(String secretKeeper) {
        super("Fidelius");
        this.secretKeeper = secretKeeper;
    }

    @Override
    public void aktifkan() {
        System.out.println("Mantra Fidelius diaktifkan. Secret Keeper: " + secretKeeper);
    }

    @Override
    public void nonaktifkan() {
        System.out.println("Mantra Fidelius dinonaktifkan. Rahasia terbuka.");
    }
}

class MantraAntiApparition extends MantraPerlindungan {
    private String area;

    public MantraAntiApparition(String area) {
        super("Mantra Anti-Apparition");
        this.area = area;
    }

    @Override
    public void aktifkan() {
        System.out.println("Apparition dilarang di area: " + area);
    }

    @Override
    public void nonaktifkan() {
        System.out.println("Apparition kembali diizinkan di area: " + area);
    }
}

class SistemPertahanan {
    private List<MantraPerlindungan> daftarMantra;

    public SistemPertahanan() {
        this.daftarMantra = new ArrayList<>();
    }

    public void tambahMantra(MantraPerlindungan mantra) {
        daftarMantra.add(mantra);
        System.out.println("Mantra ditambahkan: " + mantra.getNama());
    }

    public void aktifkanSemuaMantra() {
        System.out.println("=== Mengaktifkan semua mantra pertahanan ===");
        for (MantraPerlindungan mantra : daftarMantra) {
            mantra.aktifkan();
        }
    }

    public void nonaktifkanSemuaMantra() {
        System.out.println("=== Menonaktifkan semua mantra pertahanan ===");
        for (MantraPerlindungan mantra : daftarMantra) {
            mantra.nonaktifkan();
        }
    }
}

public class SistemPertahananHogwarts {
    public static void main(String[] args) {
        SistemPertahanan hogwarts = new SistemPertahanan();

        hogwarts.tambahMantra(new Protego());
        hogwarts.tambahMantra(new Fidelius("Dumbledore"));
        hogwarts.tambahMantra(new MantraAntiApparition("Hogwarts"));

        hogwarts.aktifkanSemuaMantra();
        System.out.println();
        hogwarts.nonaktifkanSemuaMantra();
    }
}
