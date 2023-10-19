package dse.practico2.form;

import dse.practico2.beans.ClienteBeans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cuenta extends JFrame {

    private JPanel PnlCuenta;
    private JLabel lblCuenta;
    private JLabel lblNCuenta;
    private JTextField txtNumero;
    private JButton btnConsultar;
    private JButton btnCancelar;

    public Cuenta(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlCuenta);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelar();
            }
        });
    }

    public void btnCancelar(){
        ClienteBeans cliente = new ClienteBeans();
        Menu VistaMenu = new Menu(cliente.getId_cliente());
        VistaMenu.setVisible(true);
        dispose();
    }

}
