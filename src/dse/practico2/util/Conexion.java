package dse.practico2.util;

import java.sql.*;

//Se tomo de base el archivo generado en clase, solo modificando el parametro del URL, con la nueva base de datos
public class Conexion {
    //Valores de conexion a MySql
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //El puerto es opcional
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/cautobdd";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "123456789";
    private static Driver driver = null;


    //para que no haya problemas al obtener la conexion de manera concurrente, se usa la palabra synchronized
    public static synchronized Connection getConnection()
            throws SQLException {
        Connection con = null;

        if(driver == null) {
            try {
                //se registra el driver
                Class.forName(JDBC_DRIVER);

                //con = DriverManager.getConnection (JDBC_URL,JDBC_USER,JDBC_PASS);
            }  catch (Exception e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }

    //cierre del resultSet
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    //cierre del PrepareStatement
    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    //Cierre de la conexion
    public static void close(Connection conn) {
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}