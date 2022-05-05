/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gateway;

import clienti.Cliente;
import fattura.Fattura;
import fattura.Parametri;
import java.util.ArrayList;
import java.util.List;
import metodoPagamento.MetodoPagamento;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import prodotti.Prodotto;

/**
 *
 * @author Default
 */
public interface Gateway {
    
    public Boolean memorizzaCliente(Cliente cliente);
    public ArrayList<Cliente> getClienti();
    
    public Boolean memorizzaFattura(Fattura fattura);
    public ArrayList<Fattura> getFatture(Parametri parametri);
    public Boolean modificaFattura(Fattura fattura);
    public Boolean memorizzaMetodoPagamento(MetodoPagamento metodoPagamento);
    public MetodoPagamento getMetodoPagamento();
}
