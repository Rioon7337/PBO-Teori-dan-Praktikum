/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inheritance.Hybrid;

/**
 *
 * @author ASUS
 */

//Class yang menerima inheritance hybrid,dari extends dan implements
public class Honda extends Motor implements Subsidi {
    @Override
    public void isiBBM() {
        System.out.println("Honda mengisi BBM Subsidi");
    }
}
