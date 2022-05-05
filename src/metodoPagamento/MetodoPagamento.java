/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodoPagamento;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Default
 */
public class MetodoPagamento {
    Pagamento metodo;
    String banca;
    String iban;
  

    public MetodoPagamento(Pagamento metodo, String banca, String iban) {
        this.metodo = metodo;
        this.banca = banca;
        this.iban = iban;
        
    }

    public Pagamento getMetodo() {
        return metodo;
    }

    public String getBanca() {
        return banca;
    }

    public String getIban() {
        return iban;
    }
    public void printConsole(){
        System.out.println(banca);
        System.out.println(iban);
        System.out.println(metodo);
    }
  
    
}
