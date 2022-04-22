/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

/**
 *
 * @author Default
 */
public class View implements Observer {
    Controller controller;
    Model model;
    
    View(Controller controller,Model model){
        this.controller=controller;
        this.model=model;
        model.add(this);
    }
    
    @Override
    public void update(Subject s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
