package dse.practico2.datos;

import java.sql.*;
import dse.practico2.beans.ClienteBeans;
import dse.practico2.util.Conexion;

public class ClienteDatos {
    private final String SQL_INSERT = "INSERT INTO clientes(nombre_cliente, apellido_cliente, dui_cliente, pin_cliente) VALUES (?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE clientes SET nombre_cliente=?, apellido_cliente=?, dui_cliente=?, pin_cliente=? WHERE id_cliente=?";

    private final String SQL_GET_USER_BY_DUI = "SELECT id_cliente, nombre_cliente, apellido_cliente, pin_cliente FROM clientes WHERE dui_cliente=?";

    public int insert(ClienteBeans clienteBeans){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;

            stmt.setString(index++, clienteBeans.getNombre_cliente());
            stmt.setString(index++, clienteBeans.getApellido_cliente());
            stmt.setString(index++, clienteBeans.getDui_cliente());
            stmt.setString(index++, clienteBeans.getPin_cliente());

            rows = stmt.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public boolean checkUserAuth(String dui_cliente, String pin_cliente, ClienteBeans clienteBeans){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_GET_USER_BY_DUI);
            int index = 1;

            stmt.setString(index++, dui_cliente);
            rs = stmt.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnsNumber = meta.getColumnCount();
            if(!rs.next()) return false;

            int id_cliente = (int) rs.getObject(1);
            String nombre_cliente = (String) rs.getObject(2);
            String apellido_cliente = (String) rs.getObject(3);
            String pin = (String) rs.getObject(4);

            if(!pin.equals(pin_cliente)) return false;

            clienteBeans.setId_cliente(id_cliente);
            clienteBeans.setNombre_cliente(nombre_cliente);
            clienteBeans.setApellido_cliente(apellido_cliente);
            clienteBeans.setPin_cliente(pin_cliente);
            clienteBeans.setDui_cliente(dui_cliente);
            return true;


        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return false;
    }

    ClienteDatos clienteDatos = new ClienteDatos();
    public boolean login(String dui_cliente, String pin_cliente, ClienteBeans clienteBeans){

        return clienteDatos.checkUserAuth(dui_cliente, pin_cliente, clienteBeans);
    }

    public boolean register(ClienteBeans clienteBeans){

        int rows = clienteDatos.insert(clienteBeans);

        if(rows == 0) return false;

        return true;

    }

}
