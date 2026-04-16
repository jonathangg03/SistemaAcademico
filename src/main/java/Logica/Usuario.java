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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public void eliminar() {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM usuario WHERE cedula = ?";

        try {
            CallableStatement pstmt = conexion.Conectar().prepareCall(sql);
            pstmt.setInt(1, getCedula());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario eliminado con exito.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro.");
            System.out.println("Error Consulta: " + ex.toString());
        }
    }
    
     private int contarRegistros(){
        Conexion conectar= new Conexion();
        int indice=0;
           
       try
       {
        PreparedStatement da = conectar.Conectar().prepareStatement
        ("SELECT * FROM USUARIO"); 
        ResultSet tbl = da.executeQuery();
         
         while(tbl.next())
         indice++; 
          
        }
         catch(Exception e)
         {
    
         JOptionPane.showMessageDialog(null,e.getMessage()); 
         } 
         
       return indice;
    
    }
     
      public void Listar(JTable tabla){
        Conexion conectar= new Conexion();
        DefaultTableModel tbl = new DefaultTableModel();
        int indice;
 
        tbl.addColumn("CEDULA");
        tbl.addColumn("NOMBRE COMPLETO");
        tbl.addColumn("CORREO ELECTRONICO");
        tbl.setRowCount(contarRegistros());
        try
        {
            PreparedStatement pstmt = conectar.Conectar().prepareStatement
            ("SELECT * FROM USUARIO"); 
            ResultSet tblEBD = pstmt.executeQuery();
            
            
            indice=0; 
            while(tblEBD.next())
            { 
         
            tbl.setValueAt(tblEBD.getInt("cedula"),indice,0); 
            tbl.setValueAt(tblEBD.getString("nombreCompleto"),indice,1);
            tbl.setValueAt(tblEBD.getString("correo"),indice,2); 
            indice++; 
            }
        }
            catch(SQLException e)
            {
                    
                e.printStackTrace();
                System.out.println("Eror trayendo usuarios: " + e);
            }
    
        tabla.setModel(tbl);
    }
      
    public void Actualizar() {
      Conexion conectar= new Conexion();
       try {
           String sql = "UPDATE usuario set nombreCompleto=?, correo=?, contrasena=? WHERE cedula=?";
    
            PreparedStatement pstmt = conectar.Conectar().prepareStatement(sql); 
            pstmt.setString(1, getNombreCompleto());
            pstmt.setString(2, getCorreoElectronico());
            pstmt.setString(3, getContrasena());
            pstmt.setInt(4, getCedula());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
            "USUARIO ACTUALIZADO","INFORMACION",
            JOptionPane.INFORMATION_MESSAGE);
       } 
       catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Error de edición: " + e);
        }
    
    }
    
     public void Buscar(int cedula){
        Conexion conectar= new Conexion();
 
        try
        {
            PreparedStatement pstmt = conectar.Conectar().prepareStatement
            ("SELECT * FROM usuario WHERE cedula=?"); 
            pstmt.setInt(1, cedula);
            ResultSet resultado = pstmt.executeQuery();
            
            if(resultado.next()) {
                this.setCedula(resultado.getInt("cedula"));
                this.setNombreCompleto(resultado.getString("nombreCompleto"));
                this.setCorreoElectronico(resultado.getString("correo"));
                this.setContrasena(resultado.getString("contrasena"));
            }
            
        }
            catch(SQLException e)
            {
                    
                e.printStackTrace();
                System.out.println("Eror trayendo usuarios: " + e);
            }
    }
     
}
