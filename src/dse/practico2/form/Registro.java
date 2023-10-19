package dse.practico2.form;

import dse.practico2.beans.ClienteBeans;
import dse.practico2.datos.ClienteDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Registro extends JFrame {
    ClienteBeans cliente = null;
    private JLabel lblTitle;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDui;
    private JLabel lblPin;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDui;
    private JTextField txtPin;
    private JButton btnRegresar;
    private JButton btnCrear;
    private JPanel PnlRegistro;

    public Registro (){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PnlRegistro);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());


        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegresar();
            }
        });
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCrear();
            }
        });
    }

    public void btnCrear(){
        ClienteDatos clienteDatos = new ClienteDatos();

        String nombre_cliente = this.txtNombres.getText();
        String apellido_cliente = this.txtApellidos.getText();
        String dui_cliente = this.txtDui.getText();
        String pin_cliente = generarPIN();

        cliente = new ClienteBeans(nombre_cliente, apellido_cliente, dui_cliente, pin_cliente);

        if(!clienteDatos.register(cliente)){
            JOptionPane.showMessageDialog(this, "DUI REGISTRADO");
            return;
        }
        JOptionPane.showMessageDialog(this, "CREACION CON EXITO");

        Ingreso VistaIngreso = new Ingreso();
        VistaIngreso.setVisible(true);
        this.dispose();
    }

    private String generarPIN() {
        Random random = new Random();
        int pin = 1000 + random.nextInt(9000);
        txtPin.setText(String.valueOf(pin));
        return String.valueOf(pin);
    }

    public void btnRegresar(){
        Ingreso VistaIngreso = new Ingreso();
        VistaIngreso.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new Registro();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
