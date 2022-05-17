/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FiltraFatture;

import MVC.Model;
import clienti.Cliente;
import fattura.Fattura;
import fattura.Parametri;
import gateway.Gateway;
import static gateway.Gateway.PATH_FATTURE;
import gateway.GatewayConcreto;
import java.util.ArrayList;

/**
 *
 * @author Default
 */
public class ModelFiltraFattura extends Model{
    String[]anni;
    ArrayList<Cliente> clienti;
    ArrayList<Fattura> fatture;
    float prezzoTotale;
    float iva;
    float imponibile;
    float prodotti;
    float hardware;
    float servizi;
    float daAvere;
    
    public ModelFiltraFattura(){
       
       
    }

    public void setAnni(String[] anni) {
        this.anni = anni;
        notifica();
    }

    public String[] getAnni() {
        return anni;
    }

    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(ArrayList<Cliente> clienti) {
        this.clienti = clienti;
        notifica();
    }

   

    public ArrayList<Fattura> getFatture() {
        return fatture;
    }

    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    public float getIva() {
        return iva;
    }

    public float getImponibile() {
        return imponibile;
    }

    public float getProdotti() {
        return prodotti;
    }

    public float getHardware() {
        return hardware;
    }

    public void setFatture(ArrayList<Fattura> fatture) {
        this.fatture = fatture;
        notifica();
    }

    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
        notifica();
    }

    public void setIva(float iva) {
        this.iva = iva;
        notifica();
    }

    public void setImponibile(float imponibile) {
        this.imponibile = imponibile;
        notifica();
    }

    public void setProdotti(float prodotti) {
        this.prodotti = prodotti;
        notifica();
    }

    public void setHardware(float hardware) {
        this.hardware = hardware;
        notifica();
    }

    public float getServizi() {
        return servizi;
    }

    public void setServizi(float servizi) {
        this.servizi = servizi;
        notifica();
    }

    public float getDaAvere() {
        return daAvere;
    }

    public void setDaAvere(float daAvere) {
        this.daAvere = daAvere;
        notifica();
    }
    
    
    
    
}
