/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import java.sql.*;
import javax.swing.JOptionPane;
import Datos.Conexion;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MegaByte
 */
public class Curso {
    private int cedulaDocente;
    private String nombreCurso;
    
    public Curso(){};

    public Curso(String nombreCurso, int cedulaDocente) {
        this.nombreCurso = nombreCurso;
        this.cedulaDocente = cedulaDocente;
    }

    public int getCedulaDocente() {
        return cedulaDocente;
    }

    public void setCedulaDocente(int cedulaDocente) {
        this.cedulaDocente = cedulaDocente;
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
           String sql = "INSERT INTO curso (nombre, cedulaDocente) VALUES (?, ?)";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setString(1, getNombreCurso());
            pstmt.setInt(2, getCedulaDocente());
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
    
        public void eliminar(int codigoCurso) {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM curso WHERE codigo = ?";

        try {
            CallableStatement pstmt = conexion.Conectar().prepareCall(sql);
            pstmt.setInt(1, codigoCurso);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Curso eliminado con exito.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el curso.");
            System.out.println("Error Consulta: " + ex.toString());
        }
    }
    
    private int contarRegistros() {
        Conexion conectar = new Conexion();
        int indice = 0;

        try {
            PreparedStatement da = conectar.Conectar().prepareStatement("SELECT * FROM curso");
            ResultSet tbl = da.executeQuery();

            while (tbl.next()) {
                indice++;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return indice;

    }

    public void Listar(JTable tabla) {
        Conexion conectar = new Conexion();
        DefaultTableModel tbl = new DefaultTableModel();
        int indice;

        tbl.addColumn("CODIGO");
        tbl.addColumn("NOMBRE DEL CURSO");
        tbl.addColumn("CEDULA DEL DOCENTE");
        tbl.setRowCount(contarRegistros());
        try {
            PreparedStatement pstmt = conectar.Conectar().prepareStatement("SELECT * FROM curso");
            ResultSet tblEBD = pstmt.executeQuery();

            indice = 0;
            while (tblEBD.next()) {

                tbl.setValueAt(tblEBD.getInt("codigo"), indice, 0);
                tbl.setValueAt(tblEBD.getString("nombre"), indice, 1);
                tbl.setValueAt(tblEBD.getInt("cedulaDocente"), indice, 2);
                indice++;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Eror trayendo cursos: " + e);
        }

        tabla.setModel(tbl);
    }
    
    public void Actualizar(int codigo) {
        Conexion conectar = new Conexion();
        try {
            String sql = "UPDATE curso set nombre=?, cedulaDocente=? WHERE codigo=?";

            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql);
            pstmt.setString(1, getNombreCurso());
            pstmt.setInt(2, getCedulaDocente());
            pstmt.setInt(3, codigo);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Curso Actualizado", "INFORMACION",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de edición: " + e);
        }

    }
}
