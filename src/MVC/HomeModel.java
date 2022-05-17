/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

/**
 *
 * @author Alessio
 */
public class HomeModel extends Model{
    boolean aggiungiFattura=false;
    boolean filtraFatture=true;
    boolean riepilogoFatture=false;

    public boolean isAggiungiFattura() {
        return aggiungiFattura;
    }

    public boolean isFiltraFatture() {
        return filtraFatture;
    }

    public boolean isRiepilogoFatture() {
        return riepilogoFatture;
    }

    
    public void adjValues(boolean aggiungiFattura, boolean filtraFatture, boolean riepilogoFatture){
        this.aggiungiFattura=aggiungiFattura;
        this.filtraFatture=filtraFatture;
        this.riepilogoFatture=riepilogoFatture;
        notifica();
    }
    
}
