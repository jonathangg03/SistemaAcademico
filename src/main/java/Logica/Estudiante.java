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
public class Estudiante extends Usuario{
    private double promedio;
    
    public Estudiante(){};
    
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
            String sql = "INSERT INTO estudiante (cedulaEstudiante, promedio) VALUES (?,?)";

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
        
    public void eliminar() {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM estudiante WHERE cedulaEstudiante = ?";

        try {
            CallableStatement pstmt = conexion.Conectar().prepareCall(sql);
            pstmt.setInt(1, getCedula());
            pstmt.execute();
            //JOptionPane.showMessageDialog(null, "Docente eliminado con exito.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el docente.");
            System.out.println("Error Consulta: " + ex.toString());
        }
    }
    
    public void Buscar(int cedula) {
        Conexion conectar = new Conexion();

        try {
            PreparedStatement pstmt = conectar.Conectar().prepareStatement("SELECT * FROM estudiante WHERE cedulaEstudiante=?");
            pstmt.setInt(1, cedula);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                this.setCedula(resultado.getInt("cedulaEstudiante"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Eror trayendo estudiante: " + e);
        }
    }
}
