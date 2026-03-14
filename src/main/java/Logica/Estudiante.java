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
    private int carnet;
    private Cursos curso;
    private double promedio;
    
    public Estudiante(int carnet, Cursos curso, double promedio, int id_usuario, String nombreCompleto, String correoElectronico, String contrasena, boolean activo, Roles rol) {
        super(id_usuario, nombreCompleto, correoElectronico, contrasena, activo, rol);
        this.carnet = carnet;
        this.curso = curso;
        this.promedio = promedio;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public Cursos getCarrera() {
        return curso;
    }

    public void setCarrera(Cursos carrera) {
        this.curso = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
}
