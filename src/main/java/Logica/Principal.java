/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Interfaz.MenuAdministrador;
/**
 *
 * @author MegaByte
 */
public class Principal {
    public static void main(String[] args) {
        MenuAdministrador panta = new MenuAdministrador(); //Para que al darle play exista la pantalla
        panta.setVisible(true); //Hacemos visible la pantalla
        panta.setLocationRelativeTo(null); //No la hacemos relativa a nada, por lo cual, se colocará en el centro
        //Con esto ya conectamos la interfaz con la lógica
    }
}
