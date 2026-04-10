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
 * @author dgarcia
 */
public class Administrador extends Usuario {
    public Administrador(){};
    
    public Administrador(int cedula, String nombreCompleto, String correoElectronico, String contrasena, boolean activo, Roles rol) {
        super(cedula, nombreCompleto, correoElectronico, contrasena, activo, rol);
    }

    public void Agregar() {
        Conexion conectar = new Conexion();
        try {
            String sql = "INSERT INTO admin (cedulaAdmin) VALUES (?)";

            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql);
            pstmt.setInt(1, getCedula());
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
