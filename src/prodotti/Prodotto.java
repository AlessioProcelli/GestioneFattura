/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prodotti;

/**
 *
 * @author Default
 */

public class Prodotto {
   private int iva;
   private String codice;
   private String descrizione;
   private int quantita;
   private float prezzo;
   private Tipo tipologia;

    public Prodotto(int iva, String codice, String descrizione, int quantita, float prezzo, Tipo tipologia) {
        this.iva = iva;
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.tipologia = tipologia;
    }

    public int getIva() {
        return iva;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public Tipo getTipologia() {
        return tipologia;
    }
    public void printConsole(){
        
        System.out.println(Integer.toString(iva));
        System.out.println(codice);
        System.out.println(descrizione);
        System.out.println(Integer.toString(quantita));
        System.out.println(Float.toString(prezzo));
        System.out.println(tipologia.toString());
        
    }
}
