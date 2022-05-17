/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Default
 */
public class View extends javax.swing.JFrame implements Observer {
    Controller controller;
    Model model;
    
    public View(Controller controller,Model model){
        this.controller=controller;
        this.model=model;
        this.model.add(this);
    }
    
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Controller getController() {
        return controller;
    }

    public Model getModel() {
        return model;
    }
    protected String dateToString(Date d){
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        return sd.format(d);
    }
     protected Date stringToDate(String d) throws ParseException{
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        return sd.parse(d);
    }
}
