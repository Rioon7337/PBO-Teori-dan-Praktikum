/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Getter_Setter.Contoh_01;

/**
 *
 * @author ASUS
 */
public class GetSet {
    private String name;
    
    //Method 1 - Getter
    public String getName() { return name; }
    //void tidak mengembalikkan nilai apapun, tetapi kita malah menggunakan return
    
    //Method 2 - Setter
    public void setName(String N) {
        this.name = N;
    }
}
