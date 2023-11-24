package Classes;

import java.sql.*;

public class Conexion {

    String usuario = "root";//usuario de mysql
    String clave = ""; //clave del usuario
    String url = "jdbc:mysql://localhost/control_inventario"; //base de datos

    public Connection conexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(url, usuario, clave);

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
        }

        return cn;
    }

}