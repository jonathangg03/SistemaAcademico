/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import java.sql.*;
import javax.swing.JOptionPane;
import Datos.Conexion;
/**
 *
 * @author MegaByte
 */
public class Curso {
    private int codigo;
    private String nombreCurso;
    
    public Curso(){};

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    public void Agregar()
    {
      Conexion conectar= new Conexion();
       try {
           String sql = "INSERT INTO curso (nombre) VALUES (?)";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setString(1, getNombreCurso());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
            "Se ha almacenado el curso", "INFORMACION",
            JOptionPane.INFORMATION_MESSAGE);
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
        }
    
    }
    
}
