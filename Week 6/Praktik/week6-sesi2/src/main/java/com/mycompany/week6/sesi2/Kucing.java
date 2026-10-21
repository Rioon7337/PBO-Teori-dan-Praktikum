/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week6.sesi2;

/**
 *
 * @author ASUS
 */

abstract class Hewan {
    abstract void suara();
    void tidur() {
        System.out.print("Hewan tidur\n");
    }
}

public class Kucing extends Hewan{
    void suara() {
        System.out.println("Meong\n");
    }
    
    void bergerak() {
        System.out.println("Kucing bergerak\n");
    }
    
    void tidur() {
        System.out.print("Hewan kucing tidur\n");
    }
}
