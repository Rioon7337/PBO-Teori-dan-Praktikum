/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Getter_Setter.Contoh_02;

/**
 *
 * @author ASUS
 */
public class GetSet {
    private int num;
    //method 1 - Setter
    public void setNumber(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException();
        }
        num = number;
    }
    //Method 2 - Getter
    public int getnumber() { return num; }
}
