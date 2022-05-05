/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fattura;

import clienti.Cliente;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import metodoPagamento.MetodoPagamento;
import prodotti.Prodotto;

/**
 *
 * @author Default
 */
public class FatturaPubblica extends Fattura{
    private String cig;
    private String cup;

    public FatturaPubblica( Cliente cliente, int numeroFattura, Date dataEmissione, List<Prodotto> articoli,  Tipologia tipologia, MetodoPagamento metodoPagamento, Date dataScadenza,String cig, String cup) {
        super(cliente, numeroFattura, dataEmissione, articoli, tipologia, metodoPagamento, dataScadenza);
        this.cig = cig;
        this.cup = cup;
    }

    public String getCig() {
        return cig;
    }

    public String getCup() {
        return cup;
    }
    
}
