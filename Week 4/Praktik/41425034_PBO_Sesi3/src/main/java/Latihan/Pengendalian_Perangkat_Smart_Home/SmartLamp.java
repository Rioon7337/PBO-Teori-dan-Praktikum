/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan.Pengendalian_Perangkat_Smart_Home;

/**
 *
 * @author ASUS
 */
public class SmartLamp implements Switchable, Connectable{
    private int kecerahan;
    private String p = "[Lampu Pintar]";
    private String d = "[WiFi Device]";
    
    public void setKecerahan(int kecerahan) {
        this.kecerahan = kecerahan;
    }
    
    public int getKecerahan() {
        return this.kecerahan;
    }
    
    @Override
    public void turnOn() {
        System.out.println(p + " Dinyalakan dengan kecerahan " + this.kecerahan + "%");
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
