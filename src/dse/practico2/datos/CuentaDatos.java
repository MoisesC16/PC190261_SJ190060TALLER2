package dse.practico2.datos;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import dse.practico2.beans.CuentaBeans;
import dse.practico2.util.Conexion;

public class CuentaDatos {
    private final String SQL_INSERT = "INSERT INTO cuentas(id_cliente, s_cliente) VALUES (?, ?)";
    private final String SQL_UPDATE = "UPDATE cuentas SET s_cliente=? WHERE n_cuenta=?";
    private final String SQL_GET_CUENTAS_BY_CLIENTE = "SELECT c.n_cuenta, c.s_cliente, cl.nombre_cliente, cl.apellido_cliente FROM cuentas c INNER JOIN clientes cl ON c.id_cliente = cl.id_cliente WHERE cl.id_cliente = ?";
    private final String SQL_GET_CUENTA_BY_ID = "SELECT c.n_cuenta, c.s_cliente, cl.nombre_cliente, cl.apellido_cliente FROM cuentas c INNER JOIN clientes cl ON c.id_cliente = cl.id_cliente WHERE cl.id_cliente = ? AND c.n_cuenta = ?";

    public int insert(int id_cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;

            stmt.setInt(index++, id_cliente);
            stmt.setDouble(index, 0.0);

            rows = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int updated(CuentaBeans cuentaBeans){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;

            stmt.setDouble(index++, cuentaBeans.getS_cliente());
            stmt.setInt(index, cuentaBeans.getN_cuenta());

            rows = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public DefaultTableModel getCuentas(int id_cliente){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_GET_CUENTAS_BY_CLIENTE);
            int index = 1;

            stmt.setInt(index++, id_cliente);

            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int columnsNumber = meta.getColumnCount();

            for(int i = 1; i <= columnsNumber; i++){
                dtm.addColumn(meta.getColumnLabel(i));
            }

            while(rs.next()){
                Object[] fila = new Object[columnsNumber];
                for(int i = 0; i < columnsNumber; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }

    public Object[] getCuentaById(int id_cliente, int n_cuenta){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Object[] fila = null;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_GET_CUENTA_BY_ID);
            int index = 1;

            stmt.setInt(index++, id_cliente);
            stmt.setInt(index++, n_cuenta);
            rs = stmt.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnsNumber = meta.getColumnCount();
            if(!rs.next()) return fila;

            fila = new Object[columnsNumber];
            for(int i = 0; i < columnsNumber; i++){
                fila[i] = rs.getObject(i+1);
            }

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return fila;
    }

    public boolean createCuenta(int id_cliente){
        CuentaDatos cuentaDatos = new CuentaDatos();

        int rows = cuentaDatos.insert(id_cliente);

        if(rows == 0) return false;

        return true;
    }

}
