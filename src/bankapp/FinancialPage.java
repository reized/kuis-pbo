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

public class FinancialPage extends JPanel {

    private JTextField moneyField;
    private JButton simpanBtn;
    private JButton ambilBtn;
    private JTextArea hasilSaldo;
    private int saldoAwal = 0;

    public FinancialPage() {
        setLayout(new GridLayout(4, 2));
        JLabel moneyLabel = new JLabel("Masukkan nominal: ");
        moneyField = new JTextField();
        simpanBtn = new JButton("Simpan");
        ambilBtn = new JButton("Ambil");

        // saat tombol simpan diklik
        simpanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanUang();
            }
        });

        // saat tombol ambil diklik
        ambilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ambilUang();
            }
        });

        add(moneyLabel);
        add(moneyField);
        add(simpanBtn);
        add(ambilBtn);

        hasilSaldo = new JTextArea();
        hasilSaldo.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(hasilSaldo);
        add(new JLabel());
        add(scrollpane);
    }

    // perhitungan saat menekan simpan
    private void simpanUang() {
        try {
            int nominal = Integer.parseInt(moneyField.getText());
            int saldoAkhir = saldoAwal + nominal;

            hasilSaldo.setText("Saldo akhir: " + saldoAkhir);
            saldoAwal = saldoAkhir;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid (mis. 10000)");
        }
    }

    // perhitungan saat menekan ambil
    private void ambilUang() {
        try {
            int nominal = Integer.parseInt(moneyField.getText());
            int saldoAkhir = saldoAwal - nominal;

            if (saldoAkhir < 0) {
                JOptionPane.showMessageDialog(this, "Nominal ambil melebihi uang saldo Anda");
            } else {
                hasilSaldo.setText("Saldo akhir: " + saldoAkhir);
                saldoAwal = saldoAkhir;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid (mis. 10000)");
        }
    }
}
