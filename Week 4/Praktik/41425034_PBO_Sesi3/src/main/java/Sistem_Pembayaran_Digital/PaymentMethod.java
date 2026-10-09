/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sistem_Pembayaran_Digital;

/**
 *
 * @author ASUS
 */
public interface PaymentMethod {
    double TRANSACTION_FEE = 2500.0;
    
    void pay(double amount);
    String getPaymentDetails();
}
