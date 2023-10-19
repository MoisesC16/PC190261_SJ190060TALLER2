package dse.practico2.beans;

public class TransaccionBeans {
    int id_transaccion;
    int n_cuenta;
    double monto_transaccion;
    double a_saldo;
    double d_saldo;
    String detalle;

    public TransaccionBeans(int id_transaccion, int n_cuenta, double monto_transaccion, double a_saldo, double d_saldo, String detalle){
        this.id_transaccion = id_transaccion;
        this.n_cuenta = n_cuenta;
        this.monto_transaccion = monto_transaccion;
        this.a_saldo = a_saldo;
        this.d_saldo = d_saldo;
        this.detalle = detalle;
    }

    public int getId_transaccion(){return id_transaccion;}
    public void setId_transaccion(int id_transaccion){this.id_transaccion = id_transaccion;}

    public int getN_cuenta(){return n_cuenta;}
    public void setN_cuenta(int n_cuenta){this.n_cuenta = n_cuenta;}

    public double getMonto_transaccion(){return monto_transaccion;}
    public void setMonto_transaccion(double monto_transaccion){this.monto_transaccion = monto_transaccion;}

    public double getA_saldo(){return a_saldo;}
    public void setA_saldo(double a_saldo){this.a_saldo = a_saldo;}

    public double getD_saldo(){return d_saldo;}
    public void setD_saldo(double d_saldo){this.d_saldo = d_saldo;}

    public String getDetalle(){return detalle;}
    public void setDetalle(String detalle){this.detalle = detalle;}
}
