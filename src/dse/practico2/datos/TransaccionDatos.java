package dse.practico2.datos;

import java.sql.*;
import dse.practico2.beans.TransaccionBeans;
import dse.practico2.util.Conexion;
import javax.swing.table.DefaultTableModel;
public class TransaccionDatos {
    private final String SQL_INSERT = "INSERT INTO transacciones(n_cuenta, monto_transaccion, a_saldo, d_saldo, detalle) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_GET_TRANSACCIONES = "SELECT id_transaccion, monto_transaccion, a_saldo, d_saldo, detalle FROM transacciones WHERE n_cuenta = ?";

    public int insert(TransaccionBeans transaccionBeans){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index, transaccionBeans.getN_cuenta());
            stmt.setDouble(index++, transaccionBeans.getMonto_transaccion());
            stmt.setDouble(index++, transaccionBeans.getA_saldo());
            stmt.setDouble(index++, transaccionBeans.getD_saldo());
            stmt.setString(index++, transaccionBeans.getDetalle());


            rows = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public DefaultTableModel getTransacciones(int n_cuenta){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_GET_TRANSACCIONES);
            int index = 1;

            stmt.setInt(index, n_cuenta);

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

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return dtm;
    }
}
