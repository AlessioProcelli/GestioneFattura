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
import java.util.List;
import metodoPagamento.MetodoPagamento;
import prodotti.Prodotto;

public class Fattura {
    Cliente cliente;
    int numeroFattura;
    DateFormat dataEmissione;
    List<Prodotto> articoli;
    int imponibile;
    int ivaTot;
    int totale;
    Tipologia tipologia;
    MetodoPagamento metodoPagamento;
    DateFormat dataScadenza;
}
