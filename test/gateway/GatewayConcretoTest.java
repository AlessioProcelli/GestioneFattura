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
import java.util.Calendar;
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
        assertTrue(g.eliminaCliente(clienteBusi));
        
        id =g.getIdCliente();
        ClientePubblico clientePubbli = new ClientePubblico(id, "prova1"+Integer.toString(id), "viale morgagni 64",
                "firenze", "FI", "51031", "86334519757", "MRCRSS00A01E273I", "prova@gmail.com", "KRRH6B9", "IT", "identificativo:nfisdug"); 
        g.memorizzaCliente(clientePubbli);
        assertTrue(findCliente(clientePubbli));
        assertTrue(g.eliminaCliente(clientePubbli));
    
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
        assertTrue(g.eliminaFattura(fattura));
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
    @Test
    public void testFiltraPagato(){
        ArrayList <Fattura> listFatture=g.getFatture(new Parametri());
        ArrayList <Fattura> listFatturePagato= new ArrayList();
        for(int i=0;i<listFatture.size();i++){
            Fattura current=listFatture.get(i);
            if(current.getPagato()){
                listFatturePagato.add(current);
            }
        }
           
        
        ArrayList result=g.getFatture(new Parametri(null,true,null,null));
        assertTrue(equalsFatturaList(result,listFatturePagato));
        
        
    }
    
    @Test
    public void testFiltraAnno(){
        ArrayList <Fattura> listFatture=g.getFatture(new Parametri());
        ArrayList <Fattura> listFattureAnno= new ArrayList();
        String[] anni=g.getElementiPath(Gateway.PATH_FATTURE);
        int index=ThreadLocalRandom.current().nextInt(0, anni.length);
        int anno=Integer.parseInt(anni[index]);
        for(int i=0;i<listFatture.size();i++){
            Fattura current=listFatture.get(i);
            if(getAnno(current.getDataEmissione())==anno){
                listFattureAnno.add(current);
            }
        }
           
        
        ArrayList result=g.getFatture(new Parametri(Integer.toString(anno),null,null,null));
        assertTrue(equalsFatturaList(result,listFattureAnno));
        
        
    }
    
    
    public Boolean equalsFatturaList(ArrayList<Fattura> a, ArrayList<Fattura> b){
        if(a.size()!=b.size()){
            return  false;
        }
        for(int i=0;i<a.size();i++){
            Fattura current=a.get(i);
            if(!b.contains(current)){
                return false;
            }
        }
        return true;
    }
 
    private int getAnno(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
  
   
}
