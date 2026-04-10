/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaByte
 */
public class Estudiante extends Usuario{
    private double promedio;
    
    public Estudiante(int id_usuario, String nombreCompleto, String correoElectronico, String contrasena, boolean activo, Roles rol) {
        super(id_usuario, nombreCompleto, correoElectronico, contrasena, activo, rol);
        this.promedio = 0;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
        public void Agregar() {
        Conexion conectar = new Conexion();
        try {
            String sql = "INSERT INTO usuario (cedulaDocente) VALUES (?,?)";

            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql);
            pstmt.setInt(1, getCedula());
            pstmt.setDouble(2, getPromedio());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Se ha almacenado el Usuario", "INFORMACION",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el usuario", "INFORMACION",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
