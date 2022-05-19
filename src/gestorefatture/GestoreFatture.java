/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorefatture;

import home.Home;
import filtraFatture.ControllerFiltraFattura;
import mvc.HomeController;
import mvc.HomeModel;
import filtraFatture.ModelFiltraFattura;
import clienti.Cliente;
import clienti.ClienteBusiness;
import clienti.ClientePubblico;
import fattura.Fattura;
import fattura.FatturaBusiness;
import fattura.FatturaPubblica;
import fattura.Parametri;
import fattura.Tipologia;
import gateway.GatewayConcreto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import metodoPagamento.MetodoPagamento;
import metodoPagamento.Pagamento;
import prodotti.Prodotto;
import prodotti.Tipo;
/**
 *
 * @author Default
 */

public class GestoreFatture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
  /* System.out.println("Ciao!");
   GatewayConcreto g = GatewayConcreto.getInstance();
   ClienteBusiness cliente= new ClienteBusiness(1,"prova1", "viale morgagni 64", 
           "firenze", "FI","51031","86334519757", "MRCRSS00A01E273I", "prova@gmail.com","KRRH6B9","IT");
   /*ClientePubblico cliente= new ClientePubblico(1,"prova1", "viale morgagni 64", 
           "firenze", "FI","51031","86334519757", "MRCRSS00A01E273I", "prova@gmail.com","KRRH6B9","IT","identificativo:nfisdug");*/
 //  g.memorizzaCliente(cliente);
  
  //SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    /*Date date = format.parse("2022-12-12");
    System.out.println(date.toString());*/
  
   /*MetodoPagamento metodo= new MetodoPagamento(Pagamento.G30, "BCC BANCO FIORENTINO",
           "IT85P0832538100000000083347");*/
  /*MetodoPagamento mp= g.getMetodoPagamento();
  mp.printConsole();*/
  
  /*ArrayList<Cliente> a=g.getClienti();
  System.out.println(a.size());
  for(int i=0; i<a.size();i++){
      System.out.println("++++++++++++++");
      a.get(i).printConsole();
  }*/
   /*System.out.println(id);
                  System.out.println(nome);
                  System.out.println(via);
                  System.out.println(citta);
                  System.out.println(provincia);
                  System.out.println(cap);
                  System.out.println(partitaIva);
                  System.out.println(codiceFiscale);
                  System.out.println(email);
                  System.out.println(tipologia);
                  System.out.println(codiceAnagrafico);*/
   
  /* FatturaBusiness fattura;
   Prodotto prod= new Prodotto(22, "BCVFF000", "Prodotto di prova codice 1087",1, 100, Tipo.Prodotto);
   ArrayList<Prodotto> listProd=new ArrayList<Prodotto>();
   listProd.add(prod);
   listProd.add(new Prodotto(22, "AAAAAAA", "Prodotto di prova trovami codice 1087",2,300, Tipo.Prodotto));
   MetodoPagamento metod= new MetodoPagamento(Pagamento.G60, "Banca di Prova", "908709879898");
   fattura= new FatturaBusiness(
           cliente,
           1, 
           simpleDate.parse("2022-07-02"), 
           listProd, 
           Tipologia.Fattura,
           metod,
           simpleDate.parse("2022-08-02"));
 /*  fattura= new FatturaPubblica(
           cliente,
           0, 
           simpleDate.parse("2022-05-02"), 
           listProd, 
           Tipologia.Fattura,
           metod,
           simpleDate.parse("2022-06-02"),
            "Cig:jfhf",
           "Cup:shnvh");*/

//g.memorizzaFattura(fattura);
/*int i=10;
String c= Integer.toString(i);
float b=15;
final DecimalFormat df = new DecimalFormat("0.00");
DecimalFormatSymbols dfSymbols = new DecimalFormatSymbols();
dfSymbols.setDecimalSeparator('.');
df.setDecimalFormatSymbols(dfSymbols);
String x=String.valueOf(df.format(i));
System.out.println(x);*/

/*Cliente clienteMarcio=new ClientePubblico(1,"prova1", "viale morgagni 64", 
           "firenze", "FI","51031","86334519757", "MRCRSS00A01E273I", "prova@gmail.com","KRRH6B9","IT","identificativo:nfisdug");*/
//ArrayList<Fattura> l=g.getFatture(new Parametri(null,null,null,"AAAAAAA"));
 //  System.out.println(g.getIdFattura(simpleDate.parse("2022-05-02"),"P"));
  /*for(int x=0;x<l.size();x++){
      System.out.println(l.get(x).getDataEmissione());
    }*/
  
 /* ModelFiltraFattura mf= new ModelFiltraFattura();
  ControllerFiltraFattura cf= new ControllerFiltraFattura(mf);
   FiltraFatture ff= new FiltraFatture(cf,mf);
   ff.setVisible(true);*/
 HomeModel hm= new HomeModel();
 HomeController hc= new HomeController(hm);
 Home h=new Home(hc,hm);
 h.setVisible(true);
 
}}
