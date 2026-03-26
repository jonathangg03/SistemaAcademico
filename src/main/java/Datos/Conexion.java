/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    String url = "jdbc:mysql://localhost:3306/sistemaacademico";
    String user = "root";
    String password = "Desarrollo123";
    
    public Conexion(){}; //Constructor para inicializar la conexión
    
    public Connection Conectar(){ // Definición de metodo que hace la conexión
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(url, user, password); // Ejecuta conexión con los datos de conexión
            return con; // Devuelve la conexión, ya que es el tipo de dato que espera el metodo del metodo
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
