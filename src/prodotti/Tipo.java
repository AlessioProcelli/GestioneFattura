/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodotti;

/**
 *
 * @author Default
 */
 public enum Tipo {
    Prodotto("Prodotto"),
    Servizio("Servizio");
    private final String etichetta;
    private Tipo(String text){
       etichetta=text; 
    }
    public String toString(){
        return etichetta;
    }
    }
