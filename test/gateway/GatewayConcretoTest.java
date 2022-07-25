/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gateway;

import clienti.Cliente;
import clienti.ClienteBusiness;
import clienti.ClientePubblico;
import fattura.Fattura;
import fattura.FatturaBusiness;
import fattura.FatturaPubblica;
import fattura.Parametri;
import fattura.Tipologia;

import static java.lang.Integer.max;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import metodoPagamento.MetodoPagamento;
import metodoPagamento.Pagamento;
import org.junit.Test;
import static org.junit.Assert.*;
import prodotti.Prodotto;
import prodotti.Tipo;

/**
 *
 * @author Default
 */
public class GatewayConcretoTest {
    GatewayConcreto g;
    public GatewayConcretoTest() {
        g=GatewayConcreto.getInstance();
    }
    private Boolean  findCliente(Cliente c){
        ArrayList<Cliente> list=g.getClienti();
        for (int i=0; i<list.size();i++){
            Cliente current=list.get(i);
            if(current.equals(c)){
                return true;
            } 
        
        }
        return false;
    }
    
    private Boolean findFattura(Fattura f){
        ArrayList<Fattura> listFat=g.getFatture(new Parametri());
        for(int i=0;i<listFat.size();i++){
            Fattura current=listFat.get(i);
            if(current.equals(f)){
                return true;
            }
        }
        return false;
    }
    @Test
    public void testMemorizzaCliente(){
        
        int id =g.getIdCliente();
        ClienteBusiness clienteBusi=new ClienteBusiness(id, "prova"+Integer.toString(id), "viale morgagni 64",
                "firenze", "FI", "50134", "1234567891", "MRCRSS00A01E273I", "prova@gmail.com", "KRRH6B9", "IT");
        g.memorizzaCliente(clienteBusi);
        assertTrue(findCliente(clienteBusi));
        
        id =g.getIdCliente();
        ClientePubblico clientePubbli = new ClientePubblico(id, "prova1", "viale morgagni 64",
                "firenze", "FI", "51031", "86334519757", "MRCRSS00A01E273I", "prova@gmail.com", "KRRH6B9", "IT", "identificativo:nfisdug"); 
        g.memorizzaCliente(clientePubbli);
        assertTrue(findCliente(clientePubbli));
    
    }
    @Test
    public void testMemorizzaFattura() throws ParseException{
   
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDate.parse("2022-12-12");
        MetodoPagamento mp = g.getMetodoPagamento();
        if (mp == null) {
            mp = new MetodoPagamento(Pagamento.G30, "BCC BANCO FIORENTINO",
                    "IT85P0832538100000000083347");
        }

        ArrayList<Cliente> listCli = g.getClienti();
        int indice = ThreadLocalRandom.current().nextInt(0, listCli.size());
        Cliente c = listCli.get(indice);
        Prodotto prod = new Prodotto(22, "BCVFF000", "Prodotto di prova", 1, 100, Tipo.Prodotto);
        ArrayList<Prodotto> listProd = new ArrayList<Prodotto>();
        listProd.add(prod);
        Fattura fattura;
        if (c instanceof ClienteBusiness) {
            fattura = new FatturaBusiness(
                    c,
                    g.getIdFattura(date, "B"),
                    date,
                    listProd,
                    Tipologia.Fattura,
                    mp,
                    simpleDate.parse("2022-08-02"));
        } else {
            fattura = new FatturaPubblica(
                    c,
                    g.getIdFattura(date, "P"),
                    date,
                    listProd,
                    Tipologia.Fattura,
                    mp,
                    simpleDate.parse("2022-06-02"),
                    "Cig:jfhf",
                    "Cup:shnvh",
                    "indetificativo Prova",
                    date);
        }
        g.memorizzaFattura(fattura);
        assertTrue(findFattura(fattura));
        

    }
    @Test
    public void testMemorizzaMPagamento() throws ParseException {
       MetodoPagamento current=g.getMetodoPagamento();
        
       MetodoPagamento mp = new MetodoPagamento(Pagamento.G30, "BCC BANCO FIORENTINO",
                    "IT85P0832538100000000083347");
       g.memorizzaMetodoPagamento(mp);
       assertTrue(mp.equals(g.getMetodoPagamento()));
       g.memorizzaMetodoPagamento(current);
}
    
    
   
}
