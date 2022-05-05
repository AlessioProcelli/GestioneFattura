/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fattura;

import clienti.Cliente;
import java.util.Date;

/**
 *
 * @author Default
 */

public class Parametri {
    String anno;
    Boolean pagato;
    Cliente cliente;
 
    public Parametri(String anno, Boolean  pagato , Cliente cliente){
        this.anno=anno;
        this.pagato=pagato;
        this.cliente=cliente;
    }

    public String getAnno() {
        return anno;
    }

    public Boolean getPagato() {
        return pagato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    
    
}
