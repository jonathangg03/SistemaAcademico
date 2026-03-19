/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author MegaByte
 */
public class Estudiante extends Usuario{
    private double promedio;
    
    public Estudiante(double promedio, int id_usuario, String nombreCompleto, String correoElectronico, String contrasena, boolean activo, Roles rol) {
        super(id_usuario, nombreCompleto, correoElectronico, contrasena, activo, rol);
        this.promedio = promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
}
