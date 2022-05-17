/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fattura;

import clienti.Cliente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import metodoPagamento.MetodoPagamento;
import prodotti.Prodotto;

/**
 *
 * @author Default
 */
public class FatturaBusiness extends Fattura {
    
    public FatturaBusiness(Cliente cliente, int numeroFattura, Date dataEmissione, ArrayList<Prodotto> articoli, Tipologia tipologia, MetodoPagamento metodoPagamento, Date dataScadenza) {
        super(cliente, numeroFattura, dataEmissione, articoli, tipologia, metodoPagamento, dataScadenza);
    }
    
}
