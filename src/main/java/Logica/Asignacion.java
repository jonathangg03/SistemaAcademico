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
public class Asignacion {
    private int codigoCurso;
    private int cedulaEstudiante;
    private int notaEstudiante;
    private int asistencia;
    

    public Asignacion(int codigo, int cedulaEstudiante, int codigoCurso, int codigoDocente, int notaEstudiante) {
        this.asistencia = codigo;
        this.cedulaEstudiante = cedulaEstudiante;
        this.codigoCurso = codigoCurso;
        this.notaEstudiante = notaEstudiante;
    }

    public int getCodigo() {
        return asistencia;
    }

    public void setCodigo(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(int cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int codigoDocente) {
        this.asistencia = codigoDocente;
    }

    public int getNotaEstudiante() {
        return notaEstudiante;
    }

    public void setNotaEstudiante(int notaEstudiante) {
        this.notaEstudiante = notaEstudiante;
    }
    
      public void Agregar()
    {
      Conexion conectar= new Conexion();
       try {
           String sql = "INSERT INTO asignacion (codigoCurso, cedulaEstudiante, notaEstudiante, asistenciaEstudiante) VALUES (?, ?)";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setInt(1, getCodigoCurso());
            pstmt.setInt(2, getCedulaEstudiante());
            pstmt.setInt(1, getCodigoCurso());
            pstmt.setInt(2, getCedulaEstudiante());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
            "Se asigno la información correspondiente del estudiante al curso", "INFORMACION",
            JOptionPane.INFORMATION_MESSAGE);
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
        }
    
    }
}
