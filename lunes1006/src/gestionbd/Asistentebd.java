package gestionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Asistentebd {

    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String driver = "org.sqlite.JDBC";
    String nombreBD = "empresa.sqlite";
    String url = "jdbc:sqlite:" + nombreBD;

    public void crearBD() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Base de datos creada con exito");

    }//fin metodo.

    public void crearTabla() {

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);

            sentencia = conexion.createStatement();
            String sql = "CREATE TABLE CLIENTE "
                    + "(ID      INT     PRIMARY KEY NOT NULL , "
                    + "NOMBRE       TEXT    NOT NULL ,"
                    + "APELLIDO     TEXT    NOT NULL , "
                    + "EDAD     INT )";

            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Tabla creada con exito");

    }//fin metodo.

    public void insertDatos() {

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);

            sentencia = conexion.createStatement();
            String sql = "INSERT INTO CLIENTE"
                    + "(ID , NOMBRE ,APELLIDO ,EDAD)VALUES (1 , 'joaquin' , 'valenzuela' ,20)";

            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Datos ingresados con  exito");
    }//fin metodo.

    public void mostrarDatos() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);

            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM CLIENTE";

            resultados = sentencia.executeQuery(sql);
            while (resultados.next()) {
                
                int id = resultados.getInt("ID");
                String nombre = resultados.getString("Nombre");
                String apellido = resultados.getString("Apellido");
                int edad = resultados.getInt("Edad");
                
                System.out.println("\nID: "+id 
                                   +"\nNombre:  "+nombre
                                   +"\nApellido: "+apellido
                                   +"\nEdad: "+edad);
            }
            resultados.close();
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }//fin metodo.
    public void actualizar(){
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);

            sentencia = conexion.createStatement();
            String sql = "UPDATE  CLIENTE SET NOMBRE ='Antonio' "
                    + "WHERE ID = 1";

            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Datos actualizados con  exito");
    }//fin metodo.
    public void eliminar(){
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);

            sentencia = conexion.createStatement();
            String sql = "DELETE FROM CLIENTE WHERE ID = 1";

            sentencia.executeUpdate(sql);

            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Datos borrados con  exito");
    }//fin metodo.
        
    
}//fin clase.
