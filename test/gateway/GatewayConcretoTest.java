/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gateway;

import clienti.ClienteBusiness;
import fattura.FatturaBusiness;
import fattura.Tipologia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    public GatewayConcretoTest() {
    }

    @Test
    public void testIdFattura() throws ParseException {
        GatewayConcreto g = GatewayConcreto.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        /*ClienteBusiness cliente = new ClienteBusiness(1, "prova1", "viale morgagni 64",
                "firenze", "FI", "51031", "86334519757", "MRCRSS00A01E273I", "prova@gmail.com", "KRRH6B9", "IT");
        FatturaBusiness fattura;
        Prodotto prod = new Prodotto(22, "BCVFF000", "Prodotto di prova codice 1087", 1, 100, Tipo.Prodotto);
        ArrayList<Prodotto> listProd = new ArrayList<Prodotto>();
        listProd.add(prod);
        listProd.add(new Prodotto(22, "AAAAAAA", "Prodotto di prova trovami codice 1087", 2, 300, Tipo.Prodotto));
        MetodoPagamento metod = new MetodoPagamento(Pagamento.G60, "Banca di Prova", "908709879898");
        fattura = new FatturaBusiness(
                cliente,
                1,
                simpleDate.parse("2022-07-02"),
                listProd,
                Tipologia.Fattura,
                metod,
                simpleDate.parse("2022-08-02"));*/
    int id=g.getIdFattura(simpleDate.parse("2022-08-02"),"B");
    System.out.println(id);
}
}
