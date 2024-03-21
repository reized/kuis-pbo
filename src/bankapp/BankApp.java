/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author Lab Informatika
 */
import javax.swing.*;
import java.awt.*;

public class BankApp extends JFrame {

    public BankApp() {
        setTitle("Bank AI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new CardLayout());

        // halaman login
        LoginPage loginPage = new LoginPage();
        add(loginPage, "Login");

        // halaman financial
        FinancialPage financialPage = new FinancialPage();
        add(financialPage, "Kelola Saldo");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new BankApp().setVisible(true);
    }

}
