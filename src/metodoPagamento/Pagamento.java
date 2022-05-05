/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodoPagamento;

/**
 *
 * @author Default
 */
public enum Pagamento {
    vistaFattura("VF"),
    G30("G30"),
    G60("G60"),
    G90("G90");
    
    public final String etichetta;
    private Pagamento(String text){
       etichetta=text; 
    }
    public String toString(){
        return etichetta;
    }
}
