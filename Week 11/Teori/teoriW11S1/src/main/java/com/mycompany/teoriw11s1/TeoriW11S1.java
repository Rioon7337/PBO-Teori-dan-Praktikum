/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.teoriw11s1;

/**
 *
 * @author ASUS
 */

public class TeoriW11S1 {
    public static double rataRata(int[] nilai) {
        int total = 0;
        for(int n : nilai) {
            total += n;
        }
        return total / nilai.length;
    }
    
    
    public static void main(String[] args) {
        int[] nilai = {80, 85};
        System.out.println("Rata - rata: " + rataRata(nilai));
        int a = 10;
        int b = 3;
        double bagi = a / b;
        System.out.println(bagi);
    }
}
