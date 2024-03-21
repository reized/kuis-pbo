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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {

    private JPasswordField pinField;
    private JButton loginBtn;

    public LoginPage() {
        setLayout(new GridLayout(3, 2));
        JLabel pinLabel = new JLabel("Pin: ");
        pinField = new JPasswordField();
        loginBtn = new JButton("Masuk");

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        add(pinLabel);
        add(pinField);
        add(new JLabel());
        add(loginBtn);
    }

    // proses login
    private void login() {
        String pin = new String(pinField.getPassword());
        // verifikasi pin
        if (pin.equals("123220050")) {
            ((CardLayout) getParent().getLayout()).show(getParent(), "Kelola Saldo");
        } else {
            JOptionPane.showMessageDialog(this, "Pin yang Anda masukkan salah!");
        }
    }
}
