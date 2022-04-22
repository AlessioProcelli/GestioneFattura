/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import java.util.List;

/**
 *
 * @author Default
 */
public abstract class Subject {
    List<Observer> osservatori;
    public void add(Observer o){
        osservatori.add(o);
    }
    public  Boolean remove(Observer o){
        Boolean risultato=osservatori.remove(o);
        return risultato;
    }
    public void notifica(){
        osservatori.forEach(o  -> o.update(this) );
    }
    
}
