/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan.Pengendalian_Perangkat_Smart_Home;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        SmartLamp sl1 = new SmartLamp();
        SmartAC sa1 = new SmartAC();
        
        sl1.setKecerahan(80);
        sa1.setSuhu(22);
        sl1.turnOn();
        sl1.connectToWifi("Rumah_Indah_5G", "192.168.1.50");
        sa1.turnOn();
        sa1.connectToWifi("Rumah_Indah_5G", "192.168.1.50");
        sa1.turnOff();
    }
}
