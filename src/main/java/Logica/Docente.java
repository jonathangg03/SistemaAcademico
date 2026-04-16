/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaByte
 */
public class Docente extends Usuario {

    public Docente(){};
    
    public Docente(int cedula, String nombreCompleto, String correoElectronico, String contrasena, boolean activo, Roles rol) {
        super(cedula, nombreCompleto, correoElectronico, contrasena, activo, rol);
    }

    public void Agregar() {
        Conexion conectar = new Conexion();
        try {
            String sql = "INSERT INTO docente (cedulaDocente) VALUES (?)";

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

    public void eliminar() {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM docente WHERE cedulaDocente = ?";

        try {
            CallableStatement pstmt = conexion.Conectar().prepareCall(sql);
            pstmt.setInt(1, getCedula());
            pstmt.execute();
            // JOptionPane.showMessageDialog(null, "Docente eliminado con exito.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el docente.");
            System.out.println("Error Consulta: " + ex.toString());
        }
    }
    
    public void Buscar(int cedula) {
        Conexion conectar = new Conexion();

        try {
            PreparedStatement pstmt = conectar.Conectar().prepareStatement("SELECT * FROM docente WHERE cedulaDocente=?");
            pstmt.setInt(1, cedula);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                this.setCedula(resultado.getInt("cedulaDocente"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Eror trayendo docente: " + e);
        }
    }
}
