package dse.practico2.beans;

public class ClienteBeans {
    int id_cliente;
    String nombre_cliente;
    String apellido_cliente;
    String dui_cliente;
    String pin_cliente;

    public ClienteBeans(){}
    public ClienteBeans(int id_cliente, String nombre_cliente, String apellido_cliente, String dui_cliente, String pin_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.dui_cliente = dui_cliente;
        this.pin_cliente = pin_cliente;
    }
    //Se utiliza para el registro de clientes
    public ClienteBeans(String nombre_cliente, String apellido_cliente, String dui_cliente, String pin_cliente) {
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.dui_cliente = dui_cliente;
        this.pin_cliente = pin_cliente;
    }

    public int getId_cliente(){return id_cliente;}
    public void setId_cliente(int id_cliente){this.id_cliente = id_cliente;}

    public String getNombre_cliente(){return nombre_cliente;}
    public void setNombre_cliente(String nombre_cliente){this.nombre_cliente = nombre_cliente;}

    public String getApellido_cliente(){return apellido_cliente;}
    public void setApellido_cliente(String apellido_cliente){this.apellido_cliente = apellido_cliente;}

    public String getDui_cliente(){return dui_cliente;}
    public void setDui_cliente(String dui_cliente){this.dui_cliente = dui_cliente;}

    public String getPin_cliente(){return pin_cliente;}
    public void setPin_cliente(String pin_cliente){this.pin_cliente = pin_cliente;}
}
