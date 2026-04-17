/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MegaByte
 */
public class Asignacion {
    private int codigoCurso;
    private int cedulaEstudiante;
    private int nota;
    private int asistencia;
    

    public Asignacion() {

    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(int cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }



    
    public void Agregar() {
        Conexion conectar = new Conexion();
        try {
            String sql = "INSERT INTO asignacion (codigoCurso, cedulaEstudiante, notaEstudiante, asistenciaEstudiante) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql);
            pstmt.setInt(1, getCodigoCurso());
            pstmt.setInt(2, getCedulaEstudiante());
            pstmt.setInt(3, getNota());
            pstmt.setInt(4, getAsistencia());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Actualizar() {
        Conexion conectar = new Conexion();
        try {
            String sql = "UPDATE asignacion set notaEstudiante=?, asistenciaEstudiante=? WHERE codigoCurso=? AND cedulaEstudiante=?";

            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql);
            pstmt.setInt(1, getNota());
            pstmt.setInt(2, getAsistencia());
            pstmt.setInt(3, getCodigoCurso());
            pstmt.setInt(4, getCedulaEstudiante());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Registro Actualizado", "INFORMACION",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de edición: " + e);
        }

    }


    public void Buscar(int cedulaEstudiante, int codigoCurso) {
        Conexion conectar = new Conexion();

        try {
            PreparedStatement pstmt = conectar.Conectar().prepareStatement("SELECT * FROM asignacion WHERE cedulaEstudiante=? AND codigoCurso=?");
            pstmt.setInt(1, cedulaEstudiante);
            pstmt.setInt(2, codigoCurso);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                System.out.println("ced est: " + resultado.getInt("cedulaEstudiante"));
                this.setCedulaEstudiante(resultado.getInt("cedulaEstudiante"));
                this.setCodigoCurso(resultado.getInt("codigoCurso"));
                this.setNota(resultado.getInt("notaEstudiante"));
                this.setAsistencia(resultado.getInt("asistenciaEstudiante"));
            }
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Eror trayendo docente: " + e);
        }
    }
}
