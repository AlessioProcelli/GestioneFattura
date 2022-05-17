/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aggiungiFattura;

import mvc.Controller;
import clienti.Cliente;
import clienti.ClientePubblico;
import gateway.Gateway;
import gateway.GatewayConcreto;
import java.util.ArrayList;
import java.util.Date;
import prodotti.Prodotto;

/**
 *
 * @author Alessio
 */
public class AggiungiFatturaController extends Controller{
    private AggiungiFatturaModel aggiungiFatturaModel;
    
    public AggiungiFatturaController(AggiungiFatturaModel afm){
       super(afm);
       aggiungiFatturaModel=afm;
   }
    
    public void nuovoCliente(Cliente cliente){
        ArrayList<Cliente>listaClienti=aggiungiFatturaModel.getClienti();
        listaClienti.add(cliente);
        aggiungiFatturaModel.setClienti(listaClienti);
        Gateway g=GatewayConcreto.getInstance();
        g.memorizzaCliente(cliente);
    }

    public void nuovoProdotto(Prodotto prodotto) {
        ArrayList<Prodotto>listaProdotti=aggiungiFatturaModel.getProdotti();
        listaProdotti.add(prodotto);
        float nuovoImponibile=0;
        float nuovaIva=0;
        float nuovoPrezzo=0;
        for(int i=0;i<aggiungiFatturaModel.getProdotti().size();i++){
            float prezzo=aggiungiFatturaModel.getProdotti().get(i).getPrezzo()* aggiungiFatturaModel.getProdotti().get(i).getQuantita();
            nuovoImponibile+=prezzo;
            nuovaIva+=((prezzo*aggiungiFatturaModel.getProdotti().get(i).getIva())/100);
        }
        nuovoPrezzo=nuovoImponibile+nuovaIva;
        aggiungiFatturaModel.setProdottiECosti(listaProdotti, nuovoImponibile, nuovaIva, nuovoPrezzo);
        
    }
    
    public void calcoloIdNuovaFattura(Date dataEmissione){
        Gateway g=GatewayConcreto.getInstance();
        if(aggiungiFatturaModel.getClienteSelezionato() instanceof ClientePubblico)
                aggiungiFatturaModel.setIdNuovaFattura(g.getIdFattura(dataEmissione, "P"));
        else
                aggiungiFatturaModel.setIdNuovaFattura(g.getIdFattura(dataEmissione, "B"));      
    }
    
    public void fatturaAggiunta(Date dataEmissione){
        Gateway g=GatewayConcreto.getInstance();
        int nuovoId=-1;
        if(aggiungiFatturaModel.getClienteSelezionato() instanceof ClientePubblico)
                nuovoId=g.getIdFattura(dataEmissione, "P");
        else
                nuovoId=g.getIdFattura(dataEmissione, "B");
        aggiungiFatturaModel.setIdNuovaFatturaEClearProdottieCosti(nuovoId);
    }
    
}
