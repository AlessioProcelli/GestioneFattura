/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fattura;

/**
 *
 * @author Default
 */
public enum Tipologia {
    Fattura("Fattura"),
    NotaDiCredito("NotaDiCredito");
    private final String etichetta;
    private Tipologia(String text){
       etichetta=text; 
    }
    public String toString(){
        return etichetta;
    }
}
