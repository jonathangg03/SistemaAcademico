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
public class Usuario {
    private int cedula;
    private String nombreCompleto;
    private String correoElectronico;
    private String contrasena;

    public Usuario(){};
    
    public Usuario(int id_usuario, String nombreCompleto, String correoElectronico, String contrasena, boolean activo, Roles rol) {
        this.cedula = id_usuario;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void Agregar(){
      Conexion conectar = new Conexion();
       try {
           String sql = "INSERT INTO usuario (cedula, nombreCompleto, correo, contrasena) VALUES (?,?,?,?)";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setInt(1, getCedula());
            pstmt.setString(2, getNombreCompleto());
            pstmt.setString(3, getCorreoElectronico());
            pstmt.setString(4, getContrasena());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
            "Se ha almacenado el Usuario", "INFORMACION",
            JOptionPane.INFORMATION_MESSAGE);
       }
       catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
            "Error al agregar el usuario", "INFORMACION",
            JOptionPane.ERROR_MESSAGE);
        }
    }
}
