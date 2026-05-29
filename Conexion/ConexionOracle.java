package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {
    // Configuración de la cadena de conexión para Oracle (vía Service Name o SID común de la VM)
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:umg"; // Ajustar 'xe' u 'orcl' según tu VM
    private static final String USER = "alumno";
    private static final String PASSWORD = "Umg$2026";

    public static Connection obtenerConexion() throws SQLException {
        try {
            // Registrar explícitamente el driver que agregamos en las dependencias
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC de Oracle.", e);
        }
    }
}

