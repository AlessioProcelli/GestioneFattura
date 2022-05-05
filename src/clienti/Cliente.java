/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienti;

import java.util.Objects;

/**
 *
 * @author Default
 */
public abstract class Cliente {
    protected int id;
    protected String nome;
    protected String via;
    protected String citta;
    protected String provincia;
    protected String cap;
    private String nazione;
    protected String partitaIva;
    protected String codiceFiscale;
    protected String email;
    private String codiceDestinatario;

    public Cliente(int id, String nome, String via, String citta, String provincia, String cap, String partitaIva, String codiceFiscale, String email,String codiceDestinatario,String nazione) {
        this.id = id;
        this.nome = nome;
        this.via = via;
        this.citta = citta;
        this.provincia = provincia;
        this.cap = cap;
        this.partitaIva = partitaIva;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
        this.nazione=nazione;
        this.codiceDestinatario=codiceDestinatario;
    }

    
    
    public boolean equals(Cliente obj) {
       
       
        final Cliente other = (Cliente) obj;
        if (!(id==other.id)) {
            return false;
        }
        
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.via, other.via)) {
            return false;
        }
        if (!Objects.equals(this.citta, other.citta)) {
            return false;
        }
        if (!Objects.equals(this.provincia, other.provincia)) {
            return false;
        }
        if (!Objects.equals(this.cap, other.cap)) {
            return false;
        }
        if (!Objects.equals(this.nazione, other.nazione)) {
            return false;
        }
        if (!Objects.equals(this.partitaIva, other.partitaIva)) {
            return false;
        }
        if (!Objects.equals(this.codiceFiscale, other.codiceFiscale)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.codiceDestinatario, other.codiceDestinatario)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public String getNazione() {
        return nazione;
    }

    public String getNome() {
        return nome;
    }

    public String getVia() {
        return via;
    }

    public String getCitta() {
        return citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCap() {
        return cap;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public String getCodiceDestinatario() {
        return codiceDestinatario;
    }
    
    public void printConsole(){
                  System.out.println(nome);
                  System.out.println(via);
                  System.out.println(citta);
                  System.out.println(provincia);
                  System.out.println(cap);
                  System.out.println(partitaIva);
                  System.out.println(codiceFiscale);
                  System.out.println(email);
                  System.out.println(codiceDestinatario);
                  System.out.println(nazione);
                  
    }
    
    
}
