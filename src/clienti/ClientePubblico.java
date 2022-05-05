/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienti;

/**
 *
 * @author Default
 */
public class ClientePubblico extends Cliente {
    private String codiceAnagrafico;

    public ClientePubblico(int id, String nome, String via, String citta, String provincia, String cap, String partitaIva, String codiceFiscale, String emai,String codiceDestinatario, String nazione,String codiceAnagrafico) {
        super(id, nome, via, citta, provincia, cap, partitaIva, codiceFiscale, emai,codiceDestinatario, nazione);
        this.codiceAnagrafico = codiceAnagrafico;
    }

    

    

    public String getCodiceAnagrafico() {
        return codiceAnagrafico;
    }
    @Override
    public void printConsole(){
       super.printConsole();
       System.out.println(codiceAnagrafico);
    }

}
