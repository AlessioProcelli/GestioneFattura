/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Default
 */
package fattura;

import clienti.Cliente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import metodoPagamento.MetodoPagamento;
import prodotti.Prodotto;

public  abstract class Fattura {
    private Cliente cliente;
    private int numeroFattura;
    private Date dataEmissione;
    private ArrayList<Prodotto> articoli;
    private float imponibile;
    private float ivaTot;
    private float totale;
    private Tipologia tipologia;
    private MetodoPagamento metodoPagamento;
    private Date dataScadenza;
    private Boolean pagato=false;
    private float daAvere;
    
    public Fattura(Cliente cliente, int numeroFattura, Date dataEmissione, ArrayList<Prodotto> articoli, Tipologia tipologia, MetodoPagamento metodoPagamento, Date dataScadenza) {
        this.cliente = cliente;
        this.numeroFattura = numeroFattura;
        this.dataEmissione = dataEmissione;
        this.articoli = articoli;
        this.ivaTot = ivaTot;
        this.tipologia = tipologia;
        this.metodoPagamento = metodoPagamento;
        this.dataScadenza = dataScadenza;
        calcolaImponibile();
        calcolaTotale();
        this.daAvere=totale;
    }
   

    public Cliente getCliente() {
        return cliente;
    }

    public Boolean getPagato() {
        return pagato;
    }
    
    public void setDaAvere(float d){
        this.daAvere=d;
        if(daAvere<=0){
            daAvere=0;
            pagato=true;
        }
    }

    public float getDaAvere() {
        return daAvere;
    }
    
    public void setPagato(Boolean pagato) {
        this.pagato = pagato;
        this.daAvere=0;
    }
    

    public int getNumeroFattura() {
        return numeroFattura;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public ArrayList<Prodotto> getArticoli() {
        return articoli;
    }

    public float getImponibile() {
        return imponibile;
    }

    public float getIvaTot() {
        return ivaTot;
    }

    public float getTotale() {
        return totale;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    private void calcolaImponibile() {
        
        for(int i=0;i< articoli.size();i++){
            float prezzo=articoli.get(i).getPrezzo()* articoli.get(i).getQuantita();
            imponibile+=prezzo;
            ivaTot+=((prezzo*articoli.get(i).getIva())/100);
        }
    }

    private void calcolaTotale() {
        totale=imponibile+ivaTot;
    }
    public void printConsole(){
                  cliente.printConsole();
                  System.out.println(numeroFattura);
                  System.out.println(dataEmissione);
                  for(int i=0;i<articoli.size();i++){
                      System.out.println("Articolo:"+Integer.toString(i));
                      articoli.get(i).printConsole();
                  }
                  System.out.println(Float.toString(imponibile)); 
                  System.out.println(Float.toString(ivaTot));
                  System.out.println(Float.toString(totale));
                  System.out.println(tipologia.toString());
                  metodoPagamento.printConsole();
                  System.out.println(dataScadenza);
                  
                  
    }
    
    
}
