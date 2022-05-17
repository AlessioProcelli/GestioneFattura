/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gateway;

import clienti.Cliente;
import fattura.Fattura;
import fattura.Parametri;
import java.util.ArrayList;
import java.util.Date;
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
    final String PATH_CLIENTI="../Database/Clienti/";
    final String NOME_FILE_CLIENTI="clienti.xml"; 
    final String PATH_FATTURE="../Database/Fatture/";
    final String PATH_METODOPAGAMENTO="../Database/MetodoPagamentoSalvato/";
    final String FILE_METODOPAGAMENTO="pagamento.xml";
    final String PATH_FATTURE_ARUBA="../Database/Aruba/";
    public Boolean memorizzaCliente(Cliente cliente);
    public ArrayList<Cliente> getClienti();
    public String[] getElementiPath(String path);
    public int getIdFattura(Date dat,String tipo);
    public Boolean memorizzaFattura(Fattura fattura);
    public ArrayList<Fattura> getFatture(Parametri parametri);
    public Boolean modificaFattura(Fattura fattura);
    public Boolean memorizzaMetodoPagamento(MetodoPagamento metodoPagamento);
    public MetodoPagamento getMetodoPagamento();
    public int getIdCliente();

   
}
