/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FiltraFatture;

import MVC.Controller;
import clienti.Cliente;
import fattura.Fattura;
import fattura.Parametri;
import gateway.Gateway;
import static gateway.Gateway.PATH_FATTURE;
import gateway.GatewayConcreto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import prodotti.Prodotto;
import prodotti.Tipo;

/**
 *
 * @author Default
 */
public class ControllerFiltraFattura extends Controller {
    Gateway g;
    ModelFiltraFattura model;
    
    public ControllerFiltraFattura(ModelFiltraFattura model) {
        super(model);
        g=GatewayConcreto.getInstance();
        this.model=model;
        model.setAnni(g.getElementiPath(PATH_FATTURE));
        ArrayList<Cliente> listC=g.getClienti();
        model.setClienti(listC);
       ArrayList<Fattura> listFat=g.getFatture(new Parametri(null,null,null,null));
       model.setFatture(listFat);
       correggiRisultati();
       
    }
    
    public void correggiRisultati(){
        
        ArrayList<Fattura> listFat=model.getFatture();
        float totale=0;
        float iva=0;
        float imponibile=0;
        float harware=0;
        float servizi=0;
        float daAvere=0;
        for(int i=0;i<listFat.size();i++){
            Fattura current=listFat.get(i);
            totale+=current.getTotale();
            imponibile+=current.getImponibile();
            iva+=current.getIvaTot();
            daAvere+=current.getDaAvere();
            ArrayList<Prodotto> currentArticoli= current.getArticoli();
            for(int j=0;j<currentArticoli.size();j++){
                Prodotto p=currentArticoli.get(j);
                if(p.getTipologia()==Tipo.Prodotto){
                    harware+=p.getPrezzo();
                }
                else{
                    servizi+=p.getPrezzo();
                }
            }
                    
        }
        model.setPrezzoTotale(totale);
        model.setHardware(harware);
        model.setImponibile(imponibile);
        model.setIva(iva);
        model.setServizi(servizi);
        model.setDaAvere(daAvere);
    }
    public void effettuaFiltraggio(String anno,int idCliente,Boolean pagato,String cerca) {
        
        Cliente c=null;
        if(idCliente != -1){
         c=findClienteById(idCliente);
        }
        
         Parametri p=new Parametri(anno, pagato, c,cerca);
         
         ArrayList<Fattura> lf=g.getFatture(p);
         System.out.println(lf.size());
         model.setFatture(g.getFatture(p));
         correggiRisultati();
    }
    
    public Cliente findClienteById(int id){
       
        ArrayList<Cliente> listC=model.getClienti();
        for(int i=0;i<listC.size();i++){
            if(listC.get(i).getId()==id)
                return listC.get(i);
        }
        return null;
    }

    public void visualizzaFattura(int numeroFattura, String nomeCliente,String dataEmissione) throws ParseException {
       SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
       
       Fattura f= findFatturaByIdNomeCliente(numeroFattura,nomeCliente,sd.parse(dataEmissione));
       VisualizzaFattura vf=new VisualizzaFattura(f);
       vf.setVisible(true);
        
    }

    private Fattura findFatturaByIdNomeCliente(int numeroFattura, String nomeCliente ,Date dataEmissione) {
        
        ArrayList<Fattura> listF=model.getFatture();
        Fattura result=null;
        for(int i=0;i<listF.size();i++){
            Fattura currentF=listF.get(i);
            Cliente currentC=listF.get(i).getCliente();
            if(currentF.getNumeroFattura()==numeroFattura && currentC.getNome().equals(nomeCliente) && currentF.getDataEmissione().equals(dataEmissione)){
                result=currentF;
            }
        }
        return result;
    }

    public void pagaFattura(int numeroFattura, Date dataEmissione,String nomeCliente) {
      ArrayList<Fattura> listF=model.getFatture();
      Fattura result=findFatturaByIdNomeCliente(numeroFattura,nomeCliente,dataEmissione);
      PagaFattura pf=new PagaFattura(result,this);
      pf.setVisible(true);
        
    }

    public void fatturaPagata(Fattura f) {
        ArrayList<Fattura> listF=model.getFatture();
        Fattura old= findFatturaByIdNomeCliente(f.getNumeroFattura(),f.getCliente().getNome(),f.getDataEmissione());
        int oldIndex=listF.indexOf(old);
        listF.set(oldIndex,f);
        g.memorizzaFattura(f);
        model.setFatture(listF);
        correggiRisultati();
        
        
    }
}
