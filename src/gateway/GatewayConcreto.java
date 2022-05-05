/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gateway;

import clienti.Cliente;
import clienti.ClienteBusiness;
import clienti.ClientePubblico;
import fattura.Fattura;
import fattura.FatturaBusiness;
import fattura.FatturaPubblica;
import fattura.Parametri;
import fattura.Tipologia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;   
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metodoPagamento.MetodoPagamento;
import metodoPagamento.Pagamento;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import prodotti.Prodotto;
import prodotti.Tipo;

/**
 *
 * @author Default
 */
public class GatewayConcreto implements Gateway {

final String PATH_CLIENTI="../Database/Clienti/";
final String NOME_FILE_CLIENTI="clienti.xml"; 
final String PATH_FATTURE="../Database/Fatture/";
final String PATH_METODOPAGAMENTO="../Database/MetodoPagamentoSalvato/";
final String FILE_METODOPAGAMENTO="pagamento.xml";
final String PATH_FATTURE_ARUBA="../Database/Aruba/";

    @Override
    public Boolean memorizzaCliente (Cliente cliente){
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        File fileClienti;
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            creaCartella(PATH_CLIENTI);
            fileClienti=new File(PATH_CLIENTI+NOME_FILE_CLIENTI);
            Document doc;
            Element rootElement;
            if(fileEsiste(PATH_CLIENTI,NOME_FILE_CLIENTI)){
                doc = dBuilder.parse(fileClienti);
                rootElement = doc.getDocumentElement();
            }else{
                doc=dBuilder.newDocument();
                rootElement=doc.createElement("Clienti");
                doc.appendChild(rootElement);
                
            }
            Element c = doc.createElement("Cliente");

        // Creo parametri
            c.setAttribute("id",Integer.toString(cliente.getId()));
            c.appendChild(creaElemento(doc, c, "nome", cliente.getNome()));
            c.appendChild(creaElemento(doc, c, "via", cliente.getVia()));
            c.appendChild(creaElemento(doc, c, "citta", cliente.getCitta()));
            c.appendChild(creaElemento(doc, c, "provincia", cliente.getProvincia()));
            c.appendChild(creaElemento(doc, c, "nazione", cliente.getNazione()));
            c.appendChild(creaElemento(doc, c, "cap", cliente.getCap()));
            c.appendChild(creaElemento(doc, c, "partitaIva", cliente.getPartitaIva()));
            c.appendChild(creaElemento(doc, c, "codiceFiscale", cliente.getCodiceFiscale()));
            c.appendChild(creaElemento(doc, c, "email", cliente.getEmail()));
            c.appendChild(creaElemento(doc, c, "codiceDestinatario", cliente.getCodiceDestinatario()));
            if(cliente instanceof ClientePubblico){
                c.appendChild(creaElemento(doc, c, "tipologia", "pubblico"));
                c.appendChild(creaElemento(doc, c, "codiceAnagrafico", ((ClientePubblico)cliente).getCodiceAnagrafico()));
            }
            else{
                c.appendChild(creaElemento(doc, c, "tipologia", "business"));
            }
            rootElement.appendChild(c);
            
            creaFileXML(doc,fileClienti);
            pulisciXmlFile(PATH_CLIENTI,NOME_FILE_CLIENTI);
           
    } catch (Exception e) {
            System.out.println("Errore inserimento Cliente");
            e.printStackTrace();
        }
      return true;  
    }
    
    private void pulisciXmlFile(String pathFile, String nomeFile) {
        File vecchio = new File(pathFile + nomeFile);
        File appoggio = new File(pathFile + "appoggio.xml");
        Scanner file;
        try {
            file = new Scanner(vecchio);
            PrintWriter writer = new PrintWriter(appoggio);
            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isBlank()) {
                    writer.write(line);
                    writer.write("\n");
                }

            }
            file.close();
            writer.close();
            vecchio.delete();
            appoggio.renameTo(vecchio);
        } catch (FileNotFoundException ex) {
            System.out.println("Errore Pulitura File");
            Logger.getLogger(GatewayConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Node creaElemento(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    @Override
    public ArrayList<Cliente> getClienti() {
        ArrayList<Cliente> risultato = new ArrayList<Cliente>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        File fileClienti;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            fileClienti = new File(PATH_CLIENTI + NOME_FILE_CLIENTI);
            Document doc = dBuilder.parse(fileClienti);
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("Cliente");
            for (int i = 0; i < list.getLength(); i++) {
                Cliente cliente;
                Node node = list.item(i);
                Element elemento = (Element) node;
                String id = elemento.getAttribute("id");
                String nome = elemento.getElementsByTagName("nome").item(0).getTextContent();
                String via = elemento.getElementsByTagName("via").item(0).getTextContent();
                String citta = elemento.getElementsByTagName("citta").item(0).getTextContent();
                String provincia = elemento.getElementsByTagName("provincia").item(0).getTextContent();
                String nazione = elemento.getElementsByTagName("nazione").item(0).getTextContent();
                String cap = elemento.getElementsByTagName("cap").item(0).getTextContent();
                String partitaIva = elemento.getElementsByTagName("partitaIva").item(0).getTextContent();
                String codiceFiscale = elemento.getElementsByTagName("codiceFiscale").item(0).getTextContent();
                String email = elemento.getElementsByTagName("email").item(0).getTextContent();
                String tipologia = elemento.getElementsByTagName("tipologia").item(0).getTextContent();
                String codiceDestinatario = elemento.getElementsByTagName("codiceDestinatario").item(0).getTextContent();
                if (tipologia.equals("pubblico")) {
                    String codiceAnagrafico = elemento.getElementsByTagName("codiceAnagrafico").item(0).getTextContent();
                    cliente = new ClientePubblico(Integer.parseInt(id), nome, via, citta, provincia,
                            cap, partitaIva, codiceFiscale, email, codiceDestinatario, codiceAnagrafico, nazione);
                } else {
                    cliente = new ClienteBusiness(Integer.parseInt(id), nome, via, citta, provincia,
                            cap, partitaIva, codiceFiscale, email, codiceDestinatario, nazione);
                }

                risultato.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Errore Lettura Clienti");
            e.printStackTrace();
        }
        return risultato;

    }

    private Boolean memorizzaProdotto(Prodotto prodotto, Element radice, Document doc, int id) {
        try {
            Element radProd = doc.createElement("Prodotto");
            radProd.setAttribute("Codice", prodotto.getCodice());
            radProd.setAttribute("Id", Integer.toString(id));
            radProd.appendChild(creaElemento(doc, radProd, "Iva", Integer.toString(prodotto.getIva())));
            radProd.appendChild(creaElemento(doc, radProd, "Descrizione", prodotto.getDescrizione()));
            radProd.appendChild(creaElemento(doc, radProd, "Quantita", Integer.toString(prodotto.getQuantita())));
            radProd.appendChild(creaElemento(doc, radProd, "Prezzo", Float.toString(prodotto.getPrezzo())));
            radProd.appendChild(creaElemento(doc, radProd, "Tipologia", prodotto.getTipologia().toString()));
            radice.appendChild(radProd);
        } catch (Exception e) {
            System.out.println("Errore Memorizzazione Prodotto");
            e.printStackTrace();
        }
        return true;
    }

    private Boolean memorizzaFatturaAruba(Fattura fattura) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        final DecimalFormat formattaNumero=new DecimalFormat ("0.00");
        DecimalFormatSymbols dfSymbols = new DecimalFormatSymbols();
        dfSymbols.setDecimalSeparator('.');
        formattaNumero.setDecimalFormatSymbols(dfSymbols);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Cliente cliente=fattura.getCliente();
        String codiceTipoDocumento="TD01";
        if(fattura.getTipologia()== Tipologia.NotaDiCredito){
            codiceTipoDocumento="TD04";
        }
        String formatoTrasmissione="FPR12";
        if(fattura.getCliente() instanceof ClientePubblico){
            formatoTrasmissione="FPA12";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fattura.getDataEmissione());
        String annoCorrente=Integer.toString(calendar.get(Calendar.YEAR));
       
        File fileFattura;
        List<Prodotto> prodotti= fattura.getArticoli();
         try{
         dBuilder = dbFactory.newDocumentBuilder();
            String fileName= creaUnivoco(fattura)+"_Aruba"+".xml";
            
            fileFattura=new File(PATH_FATTURE_ARUBA+fileName);  
            Document doc = dBuilder.newDocument();
            //Per rispettare formato xml per aagenzia entrate e aruba
            Element radice = doc.createElement("q1:FatturaElettronica");
            radice.setAttribute("xmlns:q1","http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2");
            radice.setAttribute("versione",formatoTrasmissione);
            
                Element fatturaHeader = doc.createElement("FatturaElettronicaHeader");
                    Element headerDati = doc.createElement("DatiTrasmissione");
                        Element headerIdTra = doc.createElement("IdTrasmittente");
                        headerIdTra.appendChild(creaElemento(doc, headerIdTra, "IdPaese", "IT"));
                        headerIdTra.appendChild(creaElemento(doc, headerIdTra, "IdCodice", "01879020517"));
                        headerDati.appendChild(headerIdTra);
                    headerDati.appendChild(creaElemento(doc, headerDati, "ProgressivoInvio",Integer.toString( fattura.getNumeroFattura())));
                    headerDati.appendChild(creaElemento(doc, headerDati, "FormatoTrasmissione",formatoTrasmissione));
                    headerDati.appendChild(creaElemento(doc, headerDati, "CodiceDestinatario",cliente.getCodiceDestinatario()));
                    
                    Element headerCedente = doc.createElement("CedentePrestatore");
                        Element cedenteDati = doc.createElement("DatiAnagrafici");
                            Element datiFiscale = doc.createElement("IdFiscaleIVA");
                            if(!(fattura.getCliente() instanceof ClientePubblico)){
                            datiFiscale.appendChild(creaElemento(doc, datiFiscale, "IdPaese","IT"));
                            datiFiscale.appendChild(creaElemento(doc, datiFiscale, "IdCodice","01417750476"));
                            }
                            cedenteDati.appendChild(datiFiscale);
                            
                        cedenteDati.appendChild(creaElemento(doc, cedenteDati, "CodiceFiscale","01417750476"));
                            Element cedenteAnagrafica = doc.createElement("Anagrafica");
                            cedenteAnagrafica.appendChild(creaElemento(doc, cedenteAnagrafica, "Denominazione","Upload snc di Ricci Luca e Procelli Paolo"));
                            cedenteDati.appendChild(cedenteAnagrafica);
                            
                        cedenteDati.appendChild(creaElemento(doc, cedenteDati, "RegimeFiscale","RF18"));
                        Element cedenteSede = doc.createElement("Sede");
                            cedenteSede.appendChild(creaElemento(doc, cedenteSede, "Indirizzo","via G. Donizetti"));
                            cedenteSede.appendChild(creaElemento(doc, cedenteSede, "NumeroCivico","17"));
                            cedenteSede.appendChild(creaElemento(doc, cedenteSede, "CAP","50019"));
                            cedenteSede.appendChild(creaElemento(doc, cedenteSede, "Comune","Sesto Fiorentino"));
                            cedenteSede.appendChild(creaElemento(doc, cedenteSede, "Provincia","FI"));
                            cedenteSede.appendChild(creaElemento(doc, cedenteSede, "Nazione","IT"));
                        Element cedenteRea = doc.createElement("IscrizioneREA");
                            cedenteRea.appendChild(creaElemento(doc, cedenteRea, "Ufficio","FI"));
                            cedenteRea.appendChild(creaElemento(doc, cedenteRea, "NumeroREA","FI-536245"));
                            cedenteRea.appendChild(creaElemento(doc, cedenteRea, "StatoLiquidazione","LN"));
                        Element cedenteContatto = doc.createElement("Contatti"); 
                            cedenteContatto.appendChild(creaElemento(doc, cedenteContatto, "Telefono","055442006"));
                            cedenteContatto.appendChild(creaElemento(doc, cedenteContatto, "Email","p.procelli@uploadsnc.it"));
                    Element headerCessionario = doc.createElement("CessionarioCommittente");
                        Element cessionarioDati = doc.createElement("DatiAnagrafici");
                            Element cessioDatiId = doc.createElement("IdFiscaleIVA");
                            cessioDatiId.appendChild(creaElemento(doc, cessioDatiId, "IdPaese",cliente.getNazione()));
                            cessioDatiId.appendChild(creaElemento(doc, cessioDatiId, "IdCodice",cliente.getCodiceFiscale()));
                            cessionarioDati.appendChild(cessioDatiId);
                            
                        cessionarioDati.appendChild(creaElemento(doc,cessionarioDati, "CodiceFiscale",cliente.getCodiceFiscale()));
                            Element cessioDatiAna = doc.createElement("Anagrafica");
                            cessioDatiAna.appendChild(creaElemento(doc, cessioDatiAna, "Denominazione",cliente.getNome()));
                        Element cessionarioSede = doc.createElement("Sede");
                        cessionarioSede.appendChild(creaElemento(doc,cessionarioSede, "Indirizzo",cliente.getVia()));
                        cessionarioSede.appendChild(creaElemento(doc,cessionarioSede, "CAP",cliente.getCap()));
                        cessionarioSede.appendChild(creaElemento(doc,cessionarioSede, "Comune",cliente.getCitta()));
                        cessionarioSede.appendChild(creaElemento(doc,cessionarioSede, "Provincia",cliente.getProvincia()));
                        cessionarioSede.appendChild(creaElemento(doc,cessionarioSede, "Nazione",cliente.getNazione()));
                
                Element fatturaBody = doc.createElement("FatturaElettronicaBody");
                    Element bodyDati = doc.createElement("DatiGenerali");
                        Element datiDoc = doc.createElement("DatiGeneraliDocumento");
                        datiDoc.appendChild(creaElemento(doc,datiDoc, "TipoDocumento",codiceTipoDocumento));
                        datiDoc.appendChild(creaElemento(doc,datiDoc, "Divisa","EUR"));
                        datiDoc.appendChild(creaElemento(doc,datiDoc, "Data",simpleDate.format(fattura.getDataEmissione())));
                        datiDoc.appendChild(creaElemento(doc,datiDoc, "Numero","FPR"+ Integer.toString(fattura.getNumeroFattura())+"/"+annoCorrente));
                        datiDoc.appendChild(creaElemento(doc,datiDoc, "ImportoTotaleDocumento",formattaNumero.format (fattura.getTotale())));
                    Element bodyBeni = doc.createElement("DatiBeniServizi"); 
                        for(int i=1;i<=prodotti.size();i++){
                            Prodotto prodCorrente= prodotti.get(i-1);
                            Element beniRadice = doc.createElement("DettaglioLinee");
                            beniRadice.appendChild(creaElemento(doc,beniRadice, "NumeroLinea",Integer.toString(i)));
                            beniRadice.appendChild(creaElemento(doc,beniRadice, "Descrizione",prodCorrente.getDescrizione()));
                            beniRadice.appendChild(creaElemento(doc,beniRadice, "Quantita",formattaNumero.format(prodCorrente.getQuantita())));
                            beniRadice.appendChild(creaElemento(doc,beniRadice, "PrezzoUnitario",formattaNumero.format(prodCorrente.getPrezzo())));
                            beniRadice.appendChild(creaElemento(doc,beniRadice, "PrezzoTotale",formattaNumero.format(prodCorrente.getQuantita()*prodCorrente.getPrezzo())));
                            beniRadice.appendChild(creaElemento(doc,beniRadice, "AliquotaIVA",formattaNumero.format(prodCorrente.getIva())));
                               
                            
                            bodyBeni.appendChild(beniRadice);    
                        }
                        Element bodyRiepilogo = doc.createElement("DatiRiepilogo");
                        bodyRiepilogo.appendChild(creaElemento(doc,bodyRiepilogo, "AliquotaIVA",formattaNumero.format(prodotti.get(0).getIva())));
                        bodyRiepilogo.appendChild(creaElemento(doc,bodyRiepilogo, "ImponibileImporto",formattaNumero.format(fattura.getImponibile())));
                        bodyRiepilogo.appendChild(creaElemento(doc,bodyRiepilogo, "Imposta",formattaNumero.format(fattura.getIvaTot())));
                        
                    Element bodyPagamento = doc.createElement("DatiPagamento");
                    bodyPagamento.appendChild(creaElemento(doc,bodyPagamento, "CondizioniPagamento","TP02"));
                        Element pagamentoDettaglio = doc.createElement("DettaglioPagamento");
                        pagamentoDettaglio.appendChild(creaElemento(doc,pagamentoDettaglio, "ModalitaPagamento","MP05"));
                        pagamentoDettaglio.appendChild(creaElemento(doc,pagamentoDettaglio, "DataScadenzaPagamento",simpleDate.format(fattura.getDataScadenza())));
                        pagamentoDettaglio.appendChild(creaElemento(doc,pagamentoDettaglio, "ImportoPagamento",formattaNumero.format(fattura.getTotale())));
                        pagamentoDettaglio.appendChild(creaElemento(doc,pagamentoDettaglio, "IstitutoFinanziario","BCC BANCO FIORENTINO"));
                        pagamentoDettaglio.appendChild(creaElemento(doc,pagamentoDettaglio, "IBAN","IT85P0832538100000000083347"));
                        
                        
            radice.appendChild(fatturaHeader);
                fatturaHeader.appendChild(headerDati);
                fatturaHeader.appendChild(headerCedente);
                    fatturaHeader.appendChild(headerCessionario);
                        
                        headerCedente.appendChild(cedenteDati);
                            
                            
                            headerCedente.appendChild(cedenteSede);
                            headerCedente.appendChild(cedenteRea);
                            headerCedente.appendChild(cedenteContatto);
                        headerCessionario.appendChild(cessionarioDati);
                            
                            cessionarioDati.appendChild(cessioDatiAna);
                        headerCessionario.appendChild(cessionarioSede);
                radice.appendChild(fatturaBody);
                    fatturaBody.appendChild(bodyDati);
                        bodyDati.appendChild(datiDoc);
                    fatturaBody.appendChild(bodyBeni); 
                        bodyBeni.appendChild(bodyRiepilogo);
                    fatturaBody.appendChild(bodyPagamento);
                        bodyPagamento.appendChild(pagamentoDettaglio);
                    
            doc.appendChild(radice);
         
           creaFileXML(doc,fileFattura); 
           pulisciXmlFile(PATH_FATTURE_ARUBA,fileName);
           
    } catch (Exception e) {
            System.out.println("Errore inserimento Fattura Aruba");
            e.printStackTrace();
        }
      return true;  
    }
    
    private void creaFileXML(Document doc,File file){
        // for output to file*/
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult streamFile = new StreamResult(file);
            transformer.transform(source, streamFile);
        } catch (Exception e) {
            System.out.println("Errore Creazione File XML");
            e.printStackTrace();
        }
    }

    private String creaUnivoco(Fattura fat){
        String risultato = null;
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            risultato = "Fat";
            risultato += Integer.toString(fat.getNumeroFattura());
            risultato += "_";
            risultato += simpleDate.format(fat.getDataEmissione());
            risultato += "_";
            if (fat instanceof FatturaPubblica) {
                risultato += "P";
            } else {
                risultato += "B";
            }
        } catch (Exception e) {
            System.out.println("Errore creazione univoco fattura ");
            e.printStackTrace();
        }
        return risultato;
    }
    
    private String[] filtraCartelleAnno(String[] anni, String anno) {
        Boolean trovato = false;
        for (int x = 0; x < anni.length; x++) {
            if (anni[x].equals(anno)) {
                trovato = true;
            }
        }
        if (trovato == true) {
            return new String[]{anno};
        } else {
            return anni;
        }

    }
    
    private ArrayList<Fattura> filtraFatturePagate(ArrayList<Fattura> list, Boolean pagate) {
        //Filtra fatture sia per pagate che per non pagate
        ArrayList<Fattura> result = new ArrayList<Fattura>();
        String p = pagate.toString();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPagato().toString().equals(p)) {
                result.add(list.get(i));
            }
        }
        return result;
    }
    
    private ArrayList<Fattura> filtraFattureCliente(ArrayList<Fattura> list, Cliente c) {
        ArrayList<Fattura> result = new ArrayList<Fattura>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCliente().equals(c)) {
                result.add(list.get(i));
            }
        }
        return result;
    }
   
    @Override
    public ArrayList<Fattura> getFatture(Parametri parametri) {
        ArrayList<Fattura> risultato = new ArrayList<Fattura>();
        String[] pathAnni = getElementiPath(PATH_FATTURE);
        if (parametri.getAnno() != null) {
            pathAnni = filtraCartelleAnno(pathAnni, parametri.getAnno());
        }
        for (int i = 0; i < pathAnni.length; i++) {
            String pathCartella = PATH_FATTURE + pathAnni[i];
            String[] fatturePath = getElementiPath(pathCartella);
            for (int j = 0; j < fatturePath.length; j++) {
                risultato.add(convertiXmlFattura(pathCartella + "/", fatturePath[j]));
            }
        }
        if (parametri.getPagato() != null) {
            risultato = filtraFatturePagate(risultato, parametri.getPagato());
        }
        if (parametri.getCliente() != null) {
            risultato = filtraFattureCliente(risultato, parametri.getCliente());
        }
        Collections.reverse(risultato);
        return risultato;
    }

    public Fattura convertiXmlFattura(String path, String file) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        File fileFattura;
        Fattura result = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            String pathFile = path + file;
            fileFattura = new File(pathFile);
            Document doc = dBuilder.parse(fileFattura);
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("Fattura");
            Element e = (Element) list.item(0);
            String numeroFatt = e.getAttribute("NumeroFattura");
            String tipo = e.getAttribute("Tipo");
            String idCliente = e.getElementsByTagName("Cliente").item(0).getTextContent();
            String dataEmissione = e.getElementsByTagName("DataEmissione").item(0).getTextContent();
            ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
            NodeList xmlProdotti = e.getElementsByTagName("Prodotto");
            for (int i = 0; i < xmlProdotti.getLength(); i++) {
                Element xmlEle = (Element) xmlProdotti.item(i);
                prodotti.add(convertiXmlProdotto(xmlEle));
            }
            String imponibile = e.getElementsByTagName("Imponibile").item(0).getTextContent();
            String ivaTot = e.getElementsByTagName("IvaTot").item(0).getTextContent();
            String totale = e.getElementsByTagName("Totale").item(0).getTextContent();
            String sTipologia = e.getElementsByTagName("Tipologia").item(0).getTextContent();
            String dataScadenza = e.getElementsByTagName("DataScadenza").item(0).getTextContent();
            String pagato = e.getElementsByTagName("Pagato").item(0).getTextContent();
            String daAvere = e.getElementsByTagName("DaAvere").item(0).getTextContent();
            Cliente cliente = trovaClienteById(Integer.parseInt(idCliente));
            MetodoPagamento mp = convertiXmlMetodoPagamento(e);
            Tipologia tipologia = Tipologia.Fattura;
            if (sTipologia.equals("NotaDiCredito")) {
                tipologia = Tipologia.NotaDiCredito;
            }
            if (tipo.equals("Pubblica")) {
                String cig = e.getElementsByTagName("Cig").item(0).getTextContent();
                String cup = e.getElementsByTagName("Cup").item(0).getTextContent();
                result = new FatturaPubblica(cliente, Integer.parseInt(numeroFatt), stringToDate(dataEmissione),
                        prodotti, tipologia, mp, stringToDate(dataScadenza), cig, cup);
            } else {
                result = new FatturaBusiness(cliente, Integer.parseInt(numeroFatt), stringToDate(dataEmissione),
                        prodotti, tipologia, mp, stringToDate(dataScadenza));
            }

            result.setDaAvere(Float.parseFloat(daAvere));
            if (pagato.equals("true")) {
                result.setPagato(Boolean.TRUE);
            }

        } catch (Exception ex) {
            System.out.println("Errore Conversione File xml to fattura");
            Logger.getLogger(GatewayConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }
    
    private Date stringToDate(String s) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDate.parse(s);
        } catch (ParseException ex) {
            System.out.println("Errore Conversione Data");
            Logger.getLogger(GatewayConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Cliente trovaClienteById(int id) {
        Cliente result = null;
        ArrayList<Cliente> clienti = getClienti();
        for (int i = 0; i < clienti.size(); i++) {
            if (clienti.get(i).getId() == id) {
                result = clienti.get(i);
            }
        }
        return result;
    }
    
    private MetodoPagamento convertiXmlMetodoPagamento(Element el) {
        MetodoPagamento result;
        NodeList node = el.getElementsByTagName("MetodoPagamento");
        Element e = (Element) node.item(0);
        String metodo = e.getElementsByTagName("Metodo").item(0).getTextContent();

        Pagamento pagamento = null;
        switch (metodo) {
            case "VF":
                pagamento = Pagamento.vistaFattura;
                break;
            case "G30":
                pagamento = Pagamento.G30;
                break;
            case "G60":
                pagamento = Pagamento.G60;
                break;
            case "G90":
                pagamento = Pagamento.G90;
                break;
        }
        String banca = e.getElementsByTagName("Banca").item(0).getTextContent();
        String iban = e.getElementsByTagName("Iban").item(0).getTextContent();
        result = new MetodoPagamento(pagamento, banca, iban);
        return result;
    }
    
    private Prodotto convertiXmlProdotto(Element e) {
        Prodotto result;
        String codice = e.getAttribute("Codice");
        String iva = e.getElementsByTagName("Iva").item(0).getTextContent();
        String descrizione = e.getElementsByTagName("Descrizione").item(0).getTextContent();
        String quantita = e.getElementsByTagName("Quantita").item(0).getTextContent();
        String prezzo = e.getElementsByTagName("Prezzo").item(0).getTextContent();
        String tipologia = e.getElementsByTagName("Tipologia").item(0).getTextContent();
        Tipo tipo = Tipo.Prodotto;
        if (tipologia.equals("Servizio")) {
            tipo = Tipo.Servizio;
        }
        result = new Prodotto(Integer.parseInt(iva), codice, descrizione, Integer.parseInt(quantita),
                Float.parseFloat(prezzo), tipo);
        return result;
    }
    
    private String[] getElementiPath(String path) {
        File f = new File(path);
        return f.list();
    }

    @Override
    public Boolean modificaFattura(Fattura fattura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean memorizzaMetodoPagamento(MetodoPagamento metodoPagamento) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        File filePagamento;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            creaCartella(PATH_METODOPAGAMENTO);
            filePagamento = new File(PATH_METODOPAGAMENTO + FILE_METODOPAGAMENTO);
            Document doc = dBuilder.newDocument();
            Element c = doc.createElement("MetodoPagamento");
            c.appendChild(creaElemento(doc, c, "banca", metodoPagamento.getBanca()));
            c.appendChild(creaElemento(doc, c, "iban", metodoPagamento.getIban()));
            c.appendChild(creaElemento(doc, c, "metodoPagamento", metodoPagamento.getMetodo().toString()));
            doc.appendChild(c);
            creaFileXML(doc, filePagamento);
            pulisciXmlFile(PATH_METODOPAGAMENTO, FILE_METODOPAGAMENTO);

        } catch (Exception e) {
            System.out.println("Errore Salvataggio MetodoPagamento");
            e.printStackTrace();
        }
        return true;
    }
  
    @Override
    public MetodoPagamento getMetodoPagamento() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        MetodoPagamento risultato = null;
        File fileMetodoPagamento;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            fileMetodoPagamento = new File(PATH_METODOPAGAMENTO + FILE_METODOPAGAMENTO);
            Document doc = dBuilder.parse(fileMetodoPagamento);
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("MetodoPagamento");
            Node metodo = list.item(0);//primo
            Element elemento = (Element) metodo;
            String banca = elemento.getElementsByTagName("banca").item(0).getTextContent();
            String iban = elemento.getElementsByTagName("iban").item(0).getTextContent();
            String metodoPagamento = elemento.getElementsByTagName("metodoPagamento").item(0).getTextContent();
            Pagamento metodoPag = null;
            switch (metodoPagamento) {
                case "VF":
                    metodoPag = Pagamento.vistaFattura;
                    break;
                case "G30":
                    metodoPag = Pagamento.G30;
                    break;
                case "G60":
                    metodoPag = Pagamento.G60;
                    break;
                case "G90":
                    metodoPag = Pagamento.G90;
                    break;
            }
            risultato = new MetodoPagamento(metodoPag, banca, iban);

        } catch (Exception e) {
            System.out.println("Errore Lettura  MetodoPagamento");
            e.printStackTrace();
        }
        return risultato;

    }

    @Override
    public Boolean memorizzaFattura(Fattura fattura) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Cliente cliente = fattura.getCliente();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fattura.getDataEmissione());
        String annoCorrente = Integer.toString(calendar.get(Calendar.YEAR));
        File fileFattura;
        List<Prodotto> prodotti = fattura.getArticoli();

        String tipo = "Business";
        if (fattura instanceof FatturaPubblica) {
            tipo = "Pubblica";
        }
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            String filePath = PATH_FATTURE + annoCorrente + "/";
            creaCartella(filePath);
            String fileName = creaUnivoco(fattura) + ".xml";
            fileFattura = new File(filePath + fileName);
            Document doc = dBuilder.newDocument();

            Element radice = doc.createElement("Fattura");
            radice.setAttribute("NumeroFattura", Integer.toString(fattura.getNumeroFattura()));
            radice.setAttribute("Tipo", tipo);
            radice.appendChild(creaElemento(doc, radice, "Cliente", Integer.toString(cliente.getId())));
            radice.appendChild(creaElemento(doc, radice, "DataEmissione", simpleDate.format(fattura.getDataEmissione())));
            for (int i = 0; i < prodotti.size(); i++) {
                memorizzaProdotto(prodotti.get(i), radice, doc, i);
            }
            memorizzaXmlMetodoPagamento(radice, doc, fattura.getMetodoPagamento());
            radice.appendChild(creaElemento(doc, radice, "Imponibile", Float.toString(fattura.getImponibile())));
            radice.appendChild(creaElemento(doc, radice, "IvaTot", Float.toString(fattura.getIvaTot())));
            radice.appendChild(creaElemento(doc, radice, "Totale", Float.toString(fattura.getTotale())));
            radice.appendChild(creaElemento(doc, radice, "Tipologia", fattura.getTipologia().toString()));
            radice.appendChild(creaElemento(doc, radice, "DataScadenza", simpleDate.format(fattura.getDataScadenza())));
            radice.appendChild(creaElemento(doc, radice, "Pagato", fattura.getPagato().toString()));
            radice.appendChild(creaElemento(doc, radice, "DaAvere", Float.toString(fattura.getDaAvere())));
            if (tipo.equals("Pubblica")) {
                FatturaPubblica fatturaP = (FatturaPubblica) fattura;
                radice.appendChild(creaElemento(doc, radice, "Cig", fatturaP.getCig()));
                radice.appendChild(creaElemento(doc, radice, "Cup", fatturaP.getCup()));
            }
            doc.appendChild(radice);
            creaFileXML(doc, fileFattura);
            pulisciXmlFile(filePath, fileName);
            memorizzaFatturaAruba(fattura);

            return true;
        } catch (Exception ex) {
            System.out.println("Errore Inserimento Fattura");
            Logger.getLogger(GatewayConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    private void memorizzaXmlMetodoPagamento(Element root, Document doc, MetodoPagamento mp){
        Element mpRoot= doc.createElement("MetodoPagamento");
        mpRoot.appendChild(creaElemento(doc, mpRoot, "Metodo",mp.getMetodo().toString()));
        mpRoot.appendChild(creaElemento(doc, mpRoot, "Banca",mp.getBanca()));
        mpRoot.appendChild(creaElemento(doc, mpRoot, "Iban",mp.getIban()));
        root.appendChild(mpRoot);
    }
    
    private Boolean creaCartella(String path) {
        File folder = new File(path);
        boolean esiste = folder.isDirectory();
        if (esiste) {
            return true;
        } else {
            boolean creato = folder.mkdirs();
            return creato;
        }

    }
    
    private Boolean fileEsiste(String path, String fileName) {
        File tempFile = new File(path+fileName);
        return tempFile.exists();
    }
    
}
