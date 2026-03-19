/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author MegaByte
 */
public class Asignacion {
    private int codigo;
    private int codigoEstudiante;
    private int codigoCurso;
    private int codigoDocente;
    private int notaEstudiante;

    public Asignacion(int codigo, int codigoEstudiante, int codigoCurso, int codigoDocente, int notaEstudiante) {
        this.codigo = codigo;
        this.codigoEstudiante = codigoEstudiante;
        this.codigoCurso = codigoCurso;
        this.codigoDocente = codigoDocente;
        this.notaEstudiante = notaEstudiante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(int codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public int getNotaEstudiante() {
        return notaEstudiante;
    }

    public void setNotaEstudiante(int notaEstudiante) {
        this.notaEstudiante = notaEstudiante;
    }
    
}
