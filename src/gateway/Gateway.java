/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gateway;

import clienti.Cliente;
import fattura.Fattura;
import fattura.Parametri;
import java.util.List;
import prodotti.Prodotto;

/**
 *
 * @author Default
 */
public interface Gateway {
    
    public Boolean memorizzaCliente(Cliente cliente);
    public List<Cliente> getClienti();
    public Boolean memorizzaProdotto(Prodotto prodotto);
    public Boolean memorizzaFattura(Fattura fattura);
    public List<Fattura> restuisciFatture(Parametri parametri);
    public Boolean modificaFattura(Fattura fattura);
}
