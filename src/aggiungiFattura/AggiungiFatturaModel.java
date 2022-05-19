/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aggiungiFattura;

import mvc.Model;
import clienti.Cliente;
import gateway.Gateway;
import gateway.GatewayConcreto;
import java.util.ArrayList;
import prodotti.Prodotto;

/**
 *
 * @author Alessio
 */
public class AggiungiFatturaModel extends Model{
    private ArrayList<Cliente> clienti=new ArrayList();
    private ArrayList<Prodotto> prodotti=new ArrayList();
    int idNuovaFattura;
    Cliente clienteSelezionato;
    float imponibile=0;

    public AggiungiFatturaModel(){
        Gateway g=GatewayConcreto.getInstance();
        clienti=g.getClienti();
        
        clienteSelezionato=clienti.get(0);
       
    }
    
    public float getImponibile() {
        return imponibile;
    }

    public float getIva() {
        return iva;
    }

    public float getPrezzoTotale() {
        return prezzoTotale;
    }
    float iva=0;
    float prezzoTotale=0; 
    
    public void setClienteSelezionato(Cliente clienteSelezionato) {
        this.clienteSelezionato = clienteSelezionato;
    }

    public Cliente getClienteSelezionato() {
        return clienteSelezionato;
    }

    public void setIdNuovaFattura(int idNuovaFattura) {
        this.idNuovaFattura = idNuovaFattura;
        notifica();
    }

    public int getIdNuovaFattura() {
        return idNuovaFattura;
    }
    
    public void setClienti(ArrayList<Cliente> clienti) {
        this.clienti = clienti;
        notifica();
    }
    
    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public void setProdottiECosti(ArrayList<Prodotto> prodotti, float imponibile, float iva, float prezzoTotale) {
        this.prodotti = prodotti;
        this.imponibile=imponibile;
        this.iva=iva;
        this.prezzoTotale=prezzoTotale;
        notifica();
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setIdNuovaFatturaEClearProdottieCosti(int nuovoId){
        idNuovaFattura=nuovoId;
        prodotti.clear();
        imponibile=0;
        iva=0;
        prezzoTotale=0;
        notifica();
    }
    
    
}
