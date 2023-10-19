package dse.practico2.form;

import javax.swing.*;
import dse.practico2.beans.ClienteBeans;
import dse.practico2.datos.ClienteDatos;
import dse.practico2.datos.CuentaDatos;
import dse.practico2.form.Menu;
import dse.practico2.form.Registro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ingreso extends JFrame{
    private JLabel lblTitle;
    private JLabel lblIntro;
    private JLabel lblDui;
    private JLabel lblPin;
    private JTextField txtDui;
    private JPasswordField txtPin;
    private JLabel lblRegistro;
    private JButton btnRegistro;
    private JButton btnIngreso;
    private JPanel PnlIngreso;

    public Ingreso(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlIngreso);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());


        btnIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngreso();
            }
        });
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegistro();
            }
        });
    }

    public Ingreso() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlIngreso);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());


        btnIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngreso();
            }
        });
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegistro();
            }
        });
    }
    public void btnRegistro(){
        Registro VistaRegistro = new Registro();
        VistaRegistro.setVisible(true);
        this.dispose();
    }
    public void btnIngreso(){
        ClienteBeans cliente = new ClienteBeans();
        /*String dui = this.txtDui.getText();
        String pin = this.txtPin.getText();

        ClienteDatos clienteDatos = new ClienteDatos();
        if(!clienteDatos.login(dui, pin, cliente)){
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            return;
        }*/

        Menu VistaMenu = new Menu(cliente.getId_cliente());
        VistaMenu.setVisible(true);
        this.dispose();
    }


    public static void main(String[] args) {
        JFrame frame = new Ingreso("Cajero Automatico - Ingreso");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
