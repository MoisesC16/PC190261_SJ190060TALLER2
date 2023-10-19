package dse.practico2.beans;

public class CuentaBeans {
    int n_cuenta;
    double s_cliente;
    int id_cliente;

    public CuentaBeans(int n_cuenta, double s_cliente, int id_cliente){
        this.n_cuenta = n_cuenta;
        this.s_cliente = s_cliente;
        this.id_cliente = id_cliente;
    }

    public int getN_cuenta(){return n_cuenta;}
    public void setN_cuenta(int n_cuenta){this.n_cuenta = n_cuenta;}

    public double getS_cliente(){return s_cliente;}
    public void setS_cliente(double s_cliente){this.s_cliente = s_cliente;}

    public int getId_cliente(){return id_cliente;}
    public void setId_cliente(int id_cliente){this.id_cliente = id_cliente;}
}
