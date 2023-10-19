package dse.practico2.form;

import dse.practico2.datos.CuentaDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Cuentas extends JFrame {
    int id_cliente;
    DefaultTableModel model = null;
    CuentaDatos cuentaC = new CuentaDatos();
    private JPanel PnlCuentas;

    public Cuentas(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlCuentas);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());
    }

    public static void main(String args[]) {
        JFrame frame = new Cuentas();
        frame.setVisible(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
