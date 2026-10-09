/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan.Pengendalian_Perangkat_Smart_Home;

/**
 *
 * @author ASUS
 */
public class SmartAC implements Switchable, Connectable{
    private int suhu;
    private String p = "[AC Pintar]";
    private String d = "[WiFi Device]";
    
    public void setSuhu(int suhu) {
        this.suhu = suhu;
    }
    
    public int getSuhu() {
        return this.suhu;
    }
    
    @Override
    public void turnOn() {
        System.out.println(p + " Dinyalakan pada suhu " + this.suhu + " C");
    }
    
    @Override
    public void turnOff() {
        System.out.println(p + " Dimatikan");
    }
    
    @Override
    public void connectToWifi(String ssid, String ipAddress) {
        System.out.println(d + " Terhubung ke jaringan: " + ssid + " (IP: " + ipAddress
                            + ")");
    }
}
