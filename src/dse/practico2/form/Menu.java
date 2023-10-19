package dse.practico2.form;

import dse.practico2.beans.ClienteBeans;
import dse.practico2.datos.CuentaDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    int idCliente;
    private JPanel PnlMenu;
    private JLabel lblTitle;
    private JButton btnCrear;
    private JButton btnRetiro;
    private JButton btnCuenta;
    private JButton btnDeposito;
    private JButton btnCuentas;
    private JButton btnTransaccion;
    private JButton btnSalir;

    public Menu(int id_cliente) {
        getComponents();

        this.idCliente = id_cliente;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlMenu);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalir();
            }
        });
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCrear();
            }
        });
        btnCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCuenta();
            }
        });
        btnCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCuentas();
            }
        });
    }

    public void btnCuentas(){
        Cuentas VistaCuentas = new Cuentas();
        VistaCuentas.setVisible(true);
        this.dispose();
    }
    public void btnCuenta(){
        Cuenta VistaCuenta = new Cuenta();
        VistaCuenta.setVisible(true);
        this.dispose();
    }
    public void btnCrear(){
        CuentaDatos cuentaC = new CuentaDatos();
        if(!cuentaC.createCuenta(this.idCliente)){
            JOptionPane.showMessageDialog(rootPane, "Error mi pana :( por favor intentelo de nuevo");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "CUENTA CREADA");
    }

    public void btnSalir(){
        Ingreso Login = new Ingreso();
        Login.setVisible(true);
        this.dispose();
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(0).setVisible(true);
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
